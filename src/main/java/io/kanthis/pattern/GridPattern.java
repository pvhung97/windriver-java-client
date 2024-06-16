package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class GridPattern extends Pattern {

    public GridPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsGridPatternAvailable") == null)
            throw new UnsupportedPatternException("Grid");
    }

    public WebElement getItem(int row, int column) {
        CommandPayload payload = GET_GRID_ITEM(element.getId(), row, column);
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
