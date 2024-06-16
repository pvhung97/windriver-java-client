package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class GridItemPattern extends Pattern {

    public GridItemPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsGridItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Grid item");
    }

    public WebElement getContainingGrid() {
        CommandPayload payload = GET_CONTAINING_GRID(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
