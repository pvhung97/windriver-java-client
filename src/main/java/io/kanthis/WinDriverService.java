package io.kanthis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.remote.service.DriverService;

import com.google.auto.service.AutoService;

public class WinDriverService extends DriverService {

    public static final String WINDRIVER_EXE_PROPERTY = "windriver.execute";
    public static final String WINDRIVER_NAME = "windriver";

    private final ExecutorService waitAvailableExecutor = Executors.newFixedThreadPool(1, r -> {
        Thread thread = new Thread(r);
        thread.setName("Wait windriver available executor");
        thread.setDaemon(true);
        return thread;
    });

    private final ReentrantLock lock = new ReentrantLock();

    protected WinDriverService(File executable, int port, Duration timeout, List<String> args, Map<String, String> environment) throws IOException {
        super(executable, port, timeout, args, environment);
    }

    @Override
    public String getDriverName() {
        return WINDRIVER_NAME;
    }

    @Override
    public String getDriverProperty() {
        return WINDRIVER_EXE_PROPERTY;
    }

    @Override
    public boolean isRunning() {
        lock.lock();
        try {
          return super.isRunning();
        } finally {
          lock.unlock();
        }
    }

    @Override
    public void start() throws IOException {
        lock.lock();

        if (isRunning()) return;
        try {
            if (getExecutable() == null) setExecutable(DriverFinder.getPath(this, getDefaultDriverOptions()).getDriverPath());
            
            process = new CommandLine(getExecutable(), getArgs().toArray(new String[0]));
            process.setEnvironmentVariables(getEnvironment());
            process.copyOutputTo(getOutputStream());
            process.executeAsync();

            CompletableFuture<Void> serverStarted = CompletableFuture.runAsync(() -> {
                waitUntilAvailable();
            }, waitAvailableExecutor);

            try {
                serverStarted.get(getTimeout().toMillis(), TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                throw new WebDriverException("Timed out waiting for driver server to start.", e);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void stop() {
        lock.lock();

        try {
            super.stop();
        } finally {
            lock.unlock();
        }
    }

    @AutoService(DriverService.Builder.class)
    public static class Builder extends DriverService.Builder<WinDriverService, WinDriverService.Builder> {

        @Override
        public int score(Capabilities capabilities) {
            int score = 0;
            if (Platform.WINDOWS.equals(capabilities.getPlatformName())) score++;
            return score;
        }

        @Override
        protected void loadSystemProperties() { }

        @Override
        protected List<String> createArgs() {
            return Arrays.asList("--urls", "http://localhost:" + getPort());
        }

        @Override
        protected WinDriverService createDriverService(File exe, int port, Duration timeout, List<String> args, Map<String, String> environment) {
            try {
                return new WinDriverService(exe, port, timeout, args, environment);
            } catch (IOException e) {
                throw new WebDriverException(e);
            }
        }

    }
    
}
