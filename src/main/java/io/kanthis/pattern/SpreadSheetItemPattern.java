package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class SpreadSheetItemPattern extends Pattern {

    public SpreadSheetItemPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsSpreadSheetItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Spread sheet item");
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> getAnnotationObjects() {
        CommandPayload payload = ANNOTATION_OBJECTS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
