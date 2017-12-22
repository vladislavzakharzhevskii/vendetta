package com.vendettasoft.vendetta.models.hibernate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vendettasoft.vendetta.models.util.ProductOrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product_order")
public class ProductOrder extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private Long pk;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthdayDate")
    private Date birthdayDate;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;


    @ManyToMany
    @JoinTable( name = "product_order_product",
            joinColumns = { @JoinColumn(name = "order_pk") },
            inverseJoinColumns = { @JoinColumn(name = "product_pk") }
    )
    @JsonManagedReference
    private List<Product> products;


    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    private ProductOrderStatus orderStatus;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public ProductOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ProductOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
