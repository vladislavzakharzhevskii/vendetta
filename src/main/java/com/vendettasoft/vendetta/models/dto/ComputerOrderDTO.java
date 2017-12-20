package com.vendettasoft.vendetta.models.dto;

import com.vendettasoft.vendetta.models.hibernate.User;

import java.util.List;

public class ComputerOrderDTO {

    private User user = new User();
    private Long baseComponentId;
    private List<Long> additionalComponentsIds;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
