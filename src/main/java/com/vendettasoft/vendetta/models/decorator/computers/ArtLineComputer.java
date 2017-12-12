package com.vendettasoft.vendetta.models.decorator.computers;

public class ArtLineComputer extends ComputerBase {

    private Long id = 1L;
    private String name = "ARTLINE";

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
        return "ARTLINE Home H43 созданы для того, что бы вы смогли легко справляться с домашними мультимедийными задачами. " +
                "А так же, комфортно чувствовали себя при выполнении любых сложных задач, таких как фото-видео- монтаж, " +
                "программирование, кодирование видеофайлов.";
    }


    /**
     * Base costs includes the next components: Body, MotherBoard, Memory;
     **/
    @Override
    public Double getCost() {
        return 4.500;
    }
}
