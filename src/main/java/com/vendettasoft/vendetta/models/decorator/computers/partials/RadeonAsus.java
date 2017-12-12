package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class RadeonAsus extends PartComputer {

    private Long id = 20500L;
    private String name = "Video Card: Radeon RX580";

    public RadeonAsus(ComponentType componentType) {
        super(componentType);
    }

    public RadeonAsus(Product product) {
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
                "ASUS ROG Strix\n" +
                "ROG Strix — это новая серия геймерских устройств в рамках бренда Republic of Gamers." +
                " Их отличительной особенностью являются высочайшая производительность, использование инновационных технологий, " +
                "безупречный уровень надежности и стильный дизайн, подчеркивающий индивидуальность каждого геймера. " +
                "Устройства серии ROG Strix – это скорость и функциональность, необходимая для победы в любой игре!\n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                13.999;
    }
}
