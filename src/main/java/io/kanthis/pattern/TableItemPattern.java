package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

@SuppressWarnings("unchecked")
public class TableItemPattern extends Pattern {

    public TableItemPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsTableItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Table item");
    }

    public List<WebElement> getRowHeaderItems() {
        CommandPayload payload = GET_ROW_HEADER_ITEMS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getColumnHeaderItems() {
        CommandPayload payload = GET_COLUMN_HEADER_ITEMS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
