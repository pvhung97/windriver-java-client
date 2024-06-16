package io.kanthis.dto;

public enum NavigateDirection {
    Parent("Parent"),
    NextSibling("NextSibling"),
    PreviousSibling("PreviousSibling"),
    FirstChild("FirstChild"),
    LastChild("LastChild");
    
    private final String value;

    NavigateDirection(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
