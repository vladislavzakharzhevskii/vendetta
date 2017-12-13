package com.vendettasoft.vendetta.models.decorator.computers.partials;

import com.vendettasoft.vendetta.models.decorator.Product;

public class AMDRyzen7 extends PartComputer {

    private Long id = 3000L;
    private String name = "Processor: AMD Ryzen 7 1700\n";

    public AMDRyzen7(ComponentType componentType) {
        super(componentType);
    }

    public AMDRyzen7(Product product) {
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
                "В новой архитектуре AMD Zen используется мощный механизм исполнения, а также поддерживается функция одновременной " +
                "многопоточности (SMT). Ядра Zen разработаны для эффективного использования имеющихся ресурсов микроархитектуры для " +
                "обеспечения максимальной вычислительной производительности. Новая трехуровневая кэш-память с низкой задержкой и новые " +
                "алгоритмы предварительной выборки значительно уменьшают количество кэш-промахов и увеличивают пропускную способность по " +
                "сравнению с предыдущей микроархитектурой.\n";
    }

    @Override
    public Double getCost() {
        return super.getCost() +
                9.580;
    }
}
