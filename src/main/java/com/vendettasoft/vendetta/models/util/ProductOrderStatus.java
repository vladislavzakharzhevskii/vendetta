package com.vendettasoft.vendetta.models.util;

public enum ProductOrderStatus {

    NEW("New"),
    IN_DELIVERING("In Delivering"),
    COMPLETED("Completed"),
    EXPIRED("Expired"),
    DISRUPTED("Disrupted");



    private String name;

    ProductOrderStatus(String name) {
        this.name = name;
    }

    //@JsonValue
    public String getName() {
        return name;
    }


    }