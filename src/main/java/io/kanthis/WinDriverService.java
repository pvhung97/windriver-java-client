package io.kanthis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.service.DriverService;

import com.google.auto.service.AutoService;

public class WinDriverService extends DriverService {

    public static final String WINDRIVER_EXE_PROPERTY = "windriver.execute";
    public static final String WINDRIVER_NAME = "windriver";

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
