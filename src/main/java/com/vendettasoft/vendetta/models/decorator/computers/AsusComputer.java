package com.vendettasoft.vendetta.models.decorator.computers;

public class AsusComputer extends ComputerBase {

    private Long id = 2L;
    private String name = "ASUS PC \n";

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
        return "Компактный и мощный игровой компьютер\n" +
                "Компактная игровая система ROG GR8 умещается в корпус объемом 4 литра, напоминая внешне игровую консоль. " +
                "Но при этом она обладает широкой функциональностью и гибкостью полноценного ПК. " +
                "Матовый корпус GR8 с оригинальным рисунком и пульсирующим логотипом серии ROG легко впишется в интерьер любой спальни или гостиной; " +
                "а благодаря компактности этот компьютер можно взять с собой на турнир в формате LAN Partу.\n";
    }

    /**
     * Base costs includes the next components: Body, MotherBoard, Memory;
     **/
    @Override
    public Double getCost() {
        return 6.500;
    }
}
