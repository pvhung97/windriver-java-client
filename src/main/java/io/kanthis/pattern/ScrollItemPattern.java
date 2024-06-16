package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class ScrollItemPattern extends Pattern {

    public ScrollItemPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsScrollItemPatternAvailable") == null)
            throw new UnsupportedPatternException("Scroll item");
    }

    public void scrollIntoView() {
        CommandPayload payload = SCROLL_INTO_VIEW(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
