package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class ValuePattern extends Pattern {

    public ValuePattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsValuePatternAvailable") == null)
            throw new UnsupportedPatternException("Value");
    }

    public void setValue(String value) {
        CommandPayload payload = SET_VALUE(element.getId(), value);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
