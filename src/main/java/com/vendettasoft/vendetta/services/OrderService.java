package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.dto.OrdersDTO;
import com.vendettasoft.vendetta.models.hibernate.Order;

public interface OrderService {

    void submitOrder(Order order);

    OrdersDTO findAllByOrderByPkDesc();

}
