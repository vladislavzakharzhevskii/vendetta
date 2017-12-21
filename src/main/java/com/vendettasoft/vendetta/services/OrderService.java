package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.hibernate.ProductOrder;

public interface OrderService {

    void submitOrder(ProductOrder productOrder);

}
