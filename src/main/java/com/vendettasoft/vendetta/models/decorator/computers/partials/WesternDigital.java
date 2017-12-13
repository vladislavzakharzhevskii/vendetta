package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class WesternDigital extends PartComputer {

    private Long id = 2062L;
    private String name = "Hard Disk: Western Digital Blue 500GB\n";

    public WesternDigital(ComponentType componentType) {
        super(componentType);
    }

    public WesternDigital(Product product) {
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
                "Жесткий диск Western Digital Blue 500GB 5400rpm 64МB WD5000AZRZ 3.5 SATA III\n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                1305;
    }
}
