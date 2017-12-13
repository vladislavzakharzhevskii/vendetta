package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class GeforceGTX1080 extends PartComputer {

    private Long id = 20600L;
    private String name = "Video Card: GeForce GTX 1080\n";

    public GeforceGTX1080(ComponentType componentType) {
        super(componentType);
    }

    public GeforceGTX1080(Product product) {
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
                "Видеокарты Gigabyte серии Xtreme Gaming созданы, чтобы удовлетворить требования игровых энтузиастов. " +
                "Видеокарты Xtreme Gaming основаны на революционной архитектуре nVidia Pascal GPU, обеспечивая невероятный игровой опыт.\n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                31.899;
    }

}
