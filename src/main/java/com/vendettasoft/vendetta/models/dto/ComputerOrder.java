package com.vendettasoft.vendetta.models.dto;

import java.util.List;

public class ComputerOrder {

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
}
