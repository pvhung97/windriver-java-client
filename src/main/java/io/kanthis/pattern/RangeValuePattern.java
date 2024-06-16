package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class RangeValuePattern extends Pattern {

    public RangeValuePattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsRangeValuePatternAvailable") == null)
            throw new UnsupportedPatternException("Range value");
    }

    public void setValue(double value) {
        CommandPayload payload = SET_RANGE_VALUE(element.getId(), value);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
