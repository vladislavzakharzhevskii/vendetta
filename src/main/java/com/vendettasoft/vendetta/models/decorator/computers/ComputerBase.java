package com.vendettasoft.vendetta.models.decorator.computers;

import com.vendettasoft.vendetta.models.decorator.Product;

public abstract class ComputerBase implements Product {

    public final static String COMPUTER_BASE = "Computer-base";

    @Override
    public String getType() {
        return COMPUTER_BASE;
    }
}
