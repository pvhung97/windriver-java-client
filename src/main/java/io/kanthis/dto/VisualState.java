package io.kanthis.dto;

public enum VisualState {
    Normal("Normal"),
    Maximized("Maximized"),
    Minimized("Minimized");
    
    private final String value;

    VisualState(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
