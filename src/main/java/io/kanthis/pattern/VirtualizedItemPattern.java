package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class VirtualizedItemPattern extends Pattern {

    public VirtualizedItemPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsVirtualizedItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Virtualized item");
    }

    public void realize() {
        CommandPayload payload = REALIZE(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
