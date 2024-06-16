package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class SpreadSheetPattern extends Pattern {

    public SpreadSheetPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsSpreadSheetPatternAvailable") == null)
            throw new UnsupportedPatternException("Spread sheet");
    }

    public WebElement getItemByName(String name) {
        CommandPayload payload = GET_SPREADSHEET_ITEM(element.getId(), name);
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
