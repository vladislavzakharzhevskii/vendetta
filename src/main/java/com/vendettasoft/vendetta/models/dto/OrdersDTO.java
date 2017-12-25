package com.vendettasoft.vendetta.models.dto;

import com.vendettasoft.vendetta.models.hibernate.Order;

import java.util.List;
import java.util.Map;

public class OrdersDTO {

    private List<Order> orders;

    private Map<String, Order> receiveRequests;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Map<String, Order> getReceiveRequests() {
        return receiveRequests;
    }

    public void setReceiveRequests(Map<String, Order> receiveRequests) {
        this.receiveRequests = receiveRequests;
    }
}
