package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

@SuppressWarnings("unchecked")
public class DropTargetPattern extends Pattern {

    public DropTargetPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsDropTargetPatternAvailable") == null)
            throw new UnsupportedPatternException("Drop target");
    }

    public List<String> getDropTargetEffects() {
        CommandPayload payload = GET_DROP_TARGET_EFFECTS(element.getId());
        return (List<String>) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
