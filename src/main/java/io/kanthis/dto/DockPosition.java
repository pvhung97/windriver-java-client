package io.kanthis.dto;

public enum DockPosition {
    Top("Top"),
    Left("Left"),
    Bottom("Bottom"),
    Right("Right"),
    Fill("Fill"),
    None("None");
    
    private final String value;

    DockPosition(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
