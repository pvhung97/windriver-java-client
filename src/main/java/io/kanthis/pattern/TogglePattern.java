package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class TogglePattern extends Pattern {

    public TogglePattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsTogglePatternAvailable") == null)
            throw new UnsupportedPatternException("Toggle");
    }

    public void toggle() {
        CommandPayload payload = TOGGLE(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
