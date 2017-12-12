package com.vendettasoft.vendetta.models.decorator.computers;

public class LenovoComputer extends ComputerBase {

    private Long id = 3L;
    private String name = "Lenovo";

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Высокая производительность, широкие возможности. Процессор Intel Core обеспечивает отличное качество графики и " +
                "высокую производительность. Его вычислительная мощность откроет перед вами новый уровень возможностей для работы " +
                "и развлечений.";
    }

    /**
     * Base costs includes the next components: Body, MotherBoard, Memory;
     **/
    @Override
    public Double getCost() {
        return 3.200;
    }
}
