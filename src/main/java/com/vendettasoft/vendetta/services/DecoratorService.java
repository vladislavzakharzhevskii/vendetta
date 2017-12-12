package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.decorator.Product;

import java.util.List;
import java.util.Map;

public interface DecoratorService {

    List<Product> getOrderModel(List<Long> partialsIds);

    Map<String, Object> getOrderModel(List<Long> partialsIds, Long baseTypeId);

    List<Product> getProductsByType(String type);

}
