package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.models.hibernate.Product;
import com.vendettasoft.vendetta.models.hibernate.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void submitOrder(ProductOrder productOrder) {

        /* calculate total sum */
        double totalSum = 0.0;
        for (Product product : productOrder.getProducts()) {
            totalSum += product.getCost();
        }
        productOrder.setTotalCost(totalSum);


        orderDAO.save(productOrder);
    }
}
