package io.kanthis;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WinDriver extends RemoteWebDriver {

    public WinDriver(URL remoteAddress, Capabilities capabilities) {
        this(new WinDriverCommandExecutor(remoteAddress), capabilities);
    }

    public WinDriver(CommandExecutor executor, Capabilities capabilities) {
        super(executor, capabilities);
    }
    
    @Override
    public TargetLocator switchTo() {
      return new WinDriverRemoteTargetLocator();
    }

    protected class WinDriverRemoteTargetLocator extends RemoteTargetLocator {
        @Override
        public WebDriver window(String windowHandleOrName) {
            execute(DriverCommand.SWITCH_TO_WINDOW(windowHandleOrName));
            return WinDriver.this;
        }
    }
}
