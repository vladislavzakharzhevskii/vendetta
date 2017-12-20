package com.vendettasoft.vendetta.models.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private Long pk;

//    @OneToOne
//    @JoinColumn(name = "user_pk")
//    private User owner;

//    @OneToMany(mappedBy = "order")
//    private List<ComputerPart> parts;


//    @Column(name = "full_sum")
//    private Double totalSum;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }


//    public Double getTotalSum() {
//        return totalSum;
//    }
//
//    public void setTotalSum(Double totalSum) {
//        this.totalSum = totalSum;
//    }
}
