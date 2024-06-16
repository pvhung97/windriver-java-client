package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

@SuppressWarnings("unchecked")
public class BasePattern extends Pattern {

    public BasePattern(RemoteWebElement element) {
        super(element);
    }

    public WebElement getLabeledBy() {
        CommandPayload payload = GET_LABELED_BY(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getControllerFor() {
        CommandPayload payload = GET_CONTROLLER_FOR(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getDescribedBy() {
        CommandPayload payload = GET_DESCRIBED_BY(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public List<WebElement> getFlowsTo() {
        CommandPayload payload = GET_FLOWS_TO(element.getId());
        return (List<WebElement>) executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void focus() {
        CommandPayload payload = FOCUS(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
}
