package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;

public class TransformPattern extends Pattern {

    public TransformPattern(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsTransformPatternAvailable") == null)
            throw new UnsupportedPatternException("Transform");
    }

    public void move(double x, double y) {
        CommandPayload payload = MOVE(element.getId(), x, y);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void resize(double width, double height) {
        CommandPayload payload = RESIZE(element.getId(), width, height);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void rotate(double value) {
        CommandPayload payload = ROTATE(element.getId(), value);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
