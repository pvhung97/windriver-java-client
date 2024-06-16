package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

@SuppressWarnings("unchecked")
public class DragPattern extends Pattern {

    public DragPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsDragPatternAvailable") == null)
            throw new UnsupportedPatternException("Drag");
    }

    public List<String> getDropEffects() {
        CommandPayload payload = GET_DROP_EFFECTS(element.getId());
        return (List<String>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getGrabbedItems() {
        CommandPayload payload = GET_GRABBED_ITEMS(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
