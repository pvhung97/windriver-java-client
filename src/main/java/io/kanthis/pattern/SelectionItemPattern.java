package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class SelectionItemPattern extends Pattern {

    public SelectionItemPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsSelectionItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Selection item");
    }

    public void select() {
        CommandPayload payload = SELECT(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void addToSelection() {
        CommandPayload payload = ADD_SELECTION(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void removeFromSelection() {
        CommandPayload payload = REMOVE_SELECTION(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public WebElement getSelectionContainer() {
        CommandPayload payload = GET_SELECTION_CONTAINER(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
