package io.kanthis.dto;

public enum ScrollAmount {
    LargeDecrement("LargeDecrement"),
    SmallDecrement("SmallDecrement"),
    NoAmount("NoAmount"),
    LargeIncrement("LargeIncrement"),
    SmallIncrement("SmallIncrement");
    
    private final String value;

    ScrollAmount(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
