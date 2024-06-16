package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;
import io.kanthis.dto.DockPosition;

public class DockPattern extends Pattern {

    public DockPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsDockPatternAvailable") == null)
            throw new UnsupportedPatternException("Dock");
    }

    public void setDockPosition(DockPosition position) {
        CommandPayload payload = SET_DOCK_POSITION(element.getId(), position);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
