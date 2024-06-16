package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class ExpandCollapsePattern extends Pattern {

    public ExpandCollapsePattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsExpandCollapsePatternAvailable") == null)
            throw new UnsupportedPatternException("Expand collapse");
    }

    public void expand() {
        CommandPayload payload = EXPAND(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void collapse() {
        CommandPayload payload = COLLAPSE(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
