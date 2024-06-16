package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

@SuppressWarnings("unchecked")
public class MultipleViewPattern extends Pattern {

    public MultipleViewPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsMultipleViewPatternAvailable") == null)
            throw new UnsupportedPatternException("Multiple view");
    }

    public List<Integer> getSupportedViewIds() {
        CommandPayload payload = GET_SUPPORTED_VIEWS(element.getId());
        return (List<Integer>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public String getViewName(int viewId) {
        CommandPayload payload = GET_VIEW_NAME(element.getId(), viewId);
        return (String) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void setCurrentView(int viewId) {
        CommandPayload payload = SET_CURRENT_VIEW(element.getId(), viewId);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
