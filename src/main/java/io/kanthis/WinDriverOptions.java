package io.kanthis;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;

import io.kanthis.dto.AutomationName;

public class WinDriverOptions extends MutableCapabilities {

    public WinDriverOptions() {
        setDefaultOptions();
    }
    
    private void setDefaultOptions() {
        setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS.toString());
        setCapability("windriver:automationName", AutomationName.UIA3);
    }

    public WinDriverOptions setAutomationName(String automationName) {
        setCapability("windriver:automationName", automationName);
        return this;
    }

    public WinDriverOptions setAppPath(String appPath) {
        setCapability("windriver:appPath", appPath);
        setCapability("windriver:aumid", (String) null);
        setCapability("windriver:nativeWindowHandle", (String) null);
        return this;
    }

    public WinDriverOptions setWorkingDirectory(String workingDirectory) {
        setCapability("windriver:workingDirectory", workingDirectory);
        return this;
    }

    public WinDriverOptions setAumid(String aumid) {
        setCapability("windriver:aumid", aumid);
        setCapability("windriver:appPath", (String) null);
        setCapability("windriver:nativeWindowHandle", (String) null);
        return this;
    }
    
    public WinDriverOptions setNativeWindowHandle(int handle) {
        setCapability("windriver:nativeWindowHandle", handle);
        setCapability("windriver:appPath", (String) null);
        setCapability("windriver:aumid", (String) null);
        return this;
    }

    public WinDriverOptions setAppArgument(List<String> arguments) {
        setCapability("windriver:appArgument", arguments);
        return this;
    }
  
    public WinDriverOptions setDelayAfterOpenApp(Duration delay) {
        setCapability("windriver:delayAfterOpenApp", delay.toMillis());
        return this;
    }

    public WinDriverOptions setMaxTreeDepth(int depth) {
        setCapability("windriver:maxTreeDepth", depth);
        return this;
    }

    public WinDriverOptions setCommandTimeout(Duration timeout) {
        setCapability("windriver:commandTimeout", timeout.toMillis());
        return this;
    }
}
