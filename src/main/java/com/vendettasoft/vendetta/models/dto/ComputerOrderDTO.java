package com.vendettasoft.vendetta.models.dto;

import java.util.Date;
import java.util.List;

public class ComputerOrderDTO {

    private String firstName;

    private String lastName;

    private Date dateBirthday;

    private String deliveryAddress;

    private Date deliveryDate;

    private Long baseComponentId;
    private List<Long> additionalComponentsIds;

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

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getBaseComponentId() {
        return baseComponentId;
    }

    public void setBaseComponentId(Long baseComponentId) {
        this.baseComponentId = baseComponentId;
    }

    public List<Long> getAdditionalComponentsIds() {
        return additionalComponentsIds;
    }

    public void setAdditionalComponentsIds(List<Long> additionalComponentsIds) {
        this.additionalComponentsIds = additionalComponentsIds;
    }
}
