package com.vendettasoft.vendetta.models.decorator;

public abstract class PartProductBase implements Product {

    protected Product product;

    public PartProductBase() {}

    public PartProductBase(Product product) {
        this.product = product;
    }

    @Override
    public abstract Long getId();

    @Override
    public abstract String getName();

    @Override
    public abstract String getDescription();

    @Override
    public abstract Double getCost();

}
