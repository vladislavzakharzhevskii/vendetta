package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.decorator.Product;

import java.util.List;
import java.util.Map;

public interface DecoratorService {

    List<Product> getOrderModel(List<Long> partialsIds);

    Product getOrderModel(Long productId);

    Map<String, Object> getOrderModel(List<Long> partialsIds, Long baseTypeId);

    List<Product> getProductsByType(String type);
        /**
         * method to set Product's inherit links to null.
         * */
    void restoreProducts();
}
