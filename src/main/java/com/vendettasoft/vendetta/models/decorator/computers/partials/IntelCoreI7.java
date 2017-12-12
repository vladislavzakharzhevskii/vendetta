package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class IntelCoreI7 extends PartComputer {

    private Long id = 3100L;
    private String name = "Processor: Intel Core i7-7700K";

    public IntelCoreI7(ComponentType componentType) {
        super(componentType);
    }

    public IntelCoreI7(Product product) {
        super(product);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return super.getName() +
                this.name;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                "Новый процессор Intel Core i7-7700K 7-го поколения, с кодовым названием микроархитектуры Kaby Lake. " +
                "Предназначен для настольной платформы Intel LGA 1151. Принадлежит к семейству высокопроизводительных процессоров Core i7 с " +
                "большим разгонным потенциалом. \n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                10.810;
    }
}
