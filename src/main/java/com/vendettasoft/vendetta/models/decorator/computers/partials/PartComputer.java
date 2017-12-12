package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.PartProductBase;
import com.vendettasoft.vendetta.models.decorator.Product;

public abstract class PartComputer extends PartProductBase {

    public final static String PARTIALS_COMPUTER = "Computer-part";
    public ComponentType componentType;

    public PartComputer(ComponentType componentType) {
        this.componentType = componentType;
    }

    public PartComputer(Product product) {
        super(product);
    }

    @Override
    public String getType() {
        return PARTIALS_COMPUTER;
    }

    public String getName() {
        if (product != null) {
            return product.getName();
        }
        return "";
    }

    public String getDescription() {
        if (product != null) {
            return product.getDescription();
        }
        return "";
    }

    public Double getCost() {
        if (product != null) {
            return product.getCost();
        }
        return 0.0;
    }


}
