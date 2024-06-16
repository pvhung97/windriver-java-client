package io.kanthis.pattern;

import static io.kanthis.WinDriverCommand.*;

import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;
import io.kanthis.dto.ZoomUnit;

public class TransformPattern2 extends Pattern {

    public TransformPattern2(RemoteWebElement element, RemoteWebDriver driver) {
        super(element, driver);
        
        if (element.getAttribute("IsTransformPattern2Available") == null)
            throw new UnsupportedPatternException("Transform2");
    }

    public void zoom(double value) {
        CommandPayload payload = ZOOM(element.getId(), value);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void zoomByUnit(ZoomUnit unit) {
        CommandPayload payload = ZOOM_BY_UNIT(element.getId(), unit);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
