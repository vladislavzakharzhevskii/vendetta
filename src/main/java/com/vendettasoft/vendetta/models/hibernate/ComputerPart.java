package com.vendettasoft.vendetta.models.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "computer_part")
public class ComputerPart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private long pk;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "cost")
    private Double cost;

    @Column(name = "type")
    private String type;


    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
