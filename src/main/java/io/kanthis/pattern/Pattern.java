package io.kanthis.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public abstract class Pattern implements WrapsElement, WrapsDriver {
    protected final RemoteWebElement element;
    protected final RemoteWebDriver driver;
    protected final RemoteExecuteMethod executeMethod;

    public Pattern(RemoteWebElement element) {
        this.element = element;
        this.driver = (RemoteWebDriver) element.getWrappedDriver();
        this.executeMethod = new RemoteExecuteMethod(driver);
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }
}
