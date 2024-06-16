package io.kanthis.dto;

public enum ZoomUnit {
    NoAmount("NoAmount"),
    LargeDecrement("LargeDecrement"),
    SmallDecrement("SmallDecrement"),
    LargeIncrement("LargeIncrement"),
    SmallIncrement("SmallIncrement");
    
    private final String value;

    ZoomUnit(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
