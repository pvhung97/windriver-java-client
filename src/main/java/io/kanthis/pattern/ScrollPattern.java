package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;
import io.kanthis.dto.ScrollAmount;

public class ScrollPattern extends Pattern {

    public ScrollPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsScrollPatternAvailable") == null)
            throw new UnsupportedPatternException("Scroll");
    }

    public void scroll(ScrollAmount horizontalAmount, ScrollAmount verticalAmount) {
        CommandPayload payload = SCROLL(element.getId(), horizontalAmount, verticalAmount);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void setScrollPercent(double horizontalPercent, double verticalPercent) {
        CommandPayload payload = SET_SCROLL_PERCENT(element.getId(), horizontalPercent, verticalPercent);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
