package com.vendettasoft.vendetta.models.util;

public enum OrderStatus {

    NEW("New"),
    IN_DELIVERING("In Delivering"),
    COMPLETED("Completed"),
    EXPIRED("Expired"),
    DISRUPTED("Disrupted");



    private String name;

    OrderStatus(String name) {
        this.name = name;
    }

    //@JsonValue
    public String getName() {
        return name;
    }


    }