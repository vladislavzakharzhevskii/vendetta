package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComponentType {

    PROCESSOR("processor"), VIDEO_CARD("video-card"), HARD_DISK("hard-disk");

    private String name;

    ComponentType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
