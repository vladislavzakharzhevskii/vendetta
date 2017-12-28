package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.models.dto.OrdersDTO;
import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.hibernate.Product;
import com.vendettasoft.vendetta.models.util.ProductOrderStatus;
import com.vendettasoft.vendetta.utils.OrderStatusResolver;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void submitOrder(Order order) {

        order.setOrderStatus(ProductOrderStatus.NEW);

        /* calculate total sum */
        double totalSum = 0.0;
        for (Product product : order.getProducts()) {
            totalSum += product.getCost();
        }
        order.setTotalCost(totalSum);


        orderDAO.save(order);
    }

    @Override
    public OrdersDTO findAllByOrderByPkDesc() {
        final OrdersDTO ordersDTO = new OrdersDTO();

        List<Order> orders = orderDAO.findAllByOrderByPkDesc();
        //init productImage collection
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                Hibernate.initialize(product);
            }
        }
        ordersDTO.setOrders(orders);

        /*recalculate statuses*/
        /*we need to set status depends on delivery date*/
        OrderStatusResolver orderStatusResolver = new OrderStatusResolver(orderDAO, orders);
        orderStatusResolver.reviewOrdersStatuses();

        Map<String, Order> receiveRequests = orderStatusResolver.getReceiveRequests();
        ordersDTO.setReceiveRequests(receiveRequests);

        return ordersDTO;
    }


}
