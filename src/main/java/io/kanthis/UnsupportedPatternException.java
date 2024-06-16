package io.kanthis;

import org.openqa.selenium.WebDriverException;

public class UnsupportedPatternException extends WebDriverException {
    public UnsupportedPatternException(String pattern) {
        super(String.format("%s pattern is not supported for this element", pattern));
    }
}
