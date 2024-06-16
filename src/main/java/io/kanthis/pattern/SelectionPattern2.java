package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class SelectionPattern2 extends Pattern {

    public SelectionPattern2(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsSelectionPattern2Available") == null)
            throw new UnsupportedPatternException("Selection2");
    }

    public WebElement getFirstSelectedItem() {
        CommandPayload payload = GET_FIRST_SELECTED(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public WebElement getLastSelectedItem() {
        CommandPayload payload = GET_LAST_SELECTED(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public WebElement getCurrentSelectedItem() {
        CommandPayload payload = GET_CURR_SELECTED(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
