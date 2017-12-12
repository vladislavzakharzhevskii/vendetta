package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class SeagateExpansion extends PartComputer {

    private Long id = 2061L;
    private String name = "Hard Disk: Seagate Expansion 1.5TB";


    public SeagateExpansion(ComponentType componentType) {
        super(componentType);
    }

    public SeagateExpansion(Product product) {
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
                "Портативный жесткий диск Seagate Expansion — это легкое в использовании решение для случаев, когда нужно мгновенно " +
                "добавить пространство для хранения данных на компьютере и взять файлы с собой.\n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                2059;
    }
}
