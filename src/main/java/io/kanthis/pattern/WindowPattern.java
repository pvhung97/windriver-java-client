package io.kanthis.pattern;

import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.remote.CommandPayload;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.UnsupportedPatternException;
import io.kanthis.dto.VisualState;

import static io.kanthis.WinDriverCommand.*;

@SuppressWarnings("unchecked")
public class WindowPattern extends Pattern {

    public WindowPattern(RemoteWebElement element) {
        super(element);
        
        if (element.getAttribute("IsWindowPatternAvailable") == null)
            throw new UnsupportedPatternException("Window");
    }

    public void setVisualState(VisualState state) {
        CommandPayload payload = SET_VISUAL_STATE(element.getId(), state);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void waitForInputIdle(int timeout) {
        CommandPayload payload = WAIT_INPUT_IDLE(element.getId(), timeout);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void close() {
        CommandPayload payload = CLOSE_WINDOW(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public Point getPosition() {
        CommandPayload payload = GET_WINDOW_RECT(element.getId());
        Map<String, Object> response = (Map<String, Object>) executeMethod.execute(payload.getName(), payload.getParameters());
        int x = ((Number) response.get("x")).intValue();
        int y = ((Number) response.get("y")).intValue();
        return new Point(x, y);
    }

    public Dimension getSize() {
        CommandPayload payload = GET_WINDOW_RECT(element.getId());
        Map<String, Object> response = (Map<String, Object>) executeMethod.execute(payload.getName(), payload.getParameters());
        int width = ((Number) response.get("width")).intValue();
        int height = ((Number) response.get("height")).intValue();
        return new Dimension(width, height);
    }

    public Rectangle getRect() {
        CommandPayload payload = GET_WINDOW_RECT(element.getId());
        Map<String, Object> response = (Map<String, Object>) executeMethod.execute(payload.getName(), payload.getParameters());
        int x = ((Number) response.get("x")).intValue();
        int y = ((Number) response.get("y")).intValue();
        int width = ((Number) response.get("width")).intValue();
        int height = ((Number) response.get("height")).intValue();
        return new Rectangle(x, y, height, width);
    }

    public void bringToTop() {
        CommandPayload payload = BRING_ON_TOP(element.getId());
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void setSize(Dimension size) {
        CommandPayload payload = SET_WINDOW_SIZE(element.getId(), size);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }

    public void setLocation(Point location) {
        CommandPayload payload = SET_WINDOW_POSITION(element.getId(), location);
        executeMethod.execute(payload.getName(), payload.getParameters());
    }
    
}
