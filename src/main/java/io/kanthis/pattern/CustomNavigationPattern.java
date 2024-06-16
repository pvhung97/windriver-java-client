package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;
import io.kanthis.dto.NavigateDirection;

public class CustomNavigationPattern extends Pattern {

    public CustomNavigationPattern(RemoteWebElement element) {
        super(element);

        if (element.getAttribute("IsCustomNavigationPatternAvailable") == null)
            throw new UnsupportedPatternException("Custom navigation");
    }

    public WebElement navigate(NavigateDirection direction) {
        CommandPayload payload = NAVIGATE_DIRECTION(element.getId(), direction);
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
