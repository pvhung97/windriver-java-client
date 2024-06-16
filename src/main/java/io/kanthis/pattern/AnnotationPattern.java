package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class AnnotationPattern extends Pattern {

    public AnnotationPattern(RemoteWebElement element) {
        super(element);

        if (element.getAttribute("IsAnnotationPatternAvailable") == null)
            throw new UnsupportedPatternException("Annotation");
    }

    public WebElement getTarget() {
        CommandPayload payload = GET_ANNOTATION_TARGET(element.getId());
        return (WebElement) executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
