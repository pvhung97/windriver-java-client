package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

@SuppressWarnings("unchecked")
public class TablePattern extends Pattern {

    public TablePattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsTablePatternAvailable") == null)
            throw new UnsupportedPatternException("Table");
    }

    public List<WebElement> getRowHeaders() {
        CommandPayload payload = GET_ROW_HEADERS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getColumnHeaders() {
        CommandPayload payload = GET_COLUMN_HEADERS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
