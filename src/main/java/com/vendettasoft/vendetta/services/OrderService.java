package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.hibernate.User;

import java.util.List;

public interface OrderService {

    void submitOrder(User user, Long basePart, List<Long> additionalParts);

}
