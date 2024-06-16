package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class InvokePattern extends Pattern {

    public InvokePattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsInvokePatternAvailable") == null)
            throw new UnsupportedPatternException("Invoke");
    }

    public void invoke() {
        CommandPayload payload = INVOKE(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
