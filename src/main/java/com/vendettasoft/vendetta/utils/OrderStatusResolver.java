package com.vendettasoft.vendetta.utils;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.util.OrderStatus;

import java.util.*;

public class OrderStatusResolver {

    private OrderDAO orderDAO;
    private final List<Order> orders;

    private final long currentTime =
            Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault()).getTimeInMillis();

    private Map<String, Order> receiveRequests = new HashMap<>();

    public OrderStatusResolver(OrderDAO orderDAO, List<Order> orders) {
        this.orders = orders;
        this.orderDAO = orderDAO;
    }

    public void reviewOrdersStatuses() {

        //TO COMPLETED
        changeStatusesToCompleted();
        //TO EXPIRED
        changeStatusesToExpired();

        orderDAO.save(orders);
    }

    private void changeStatusesToCompleted() {

        for (Order order : orders) {
            if (order.getOrderStatus().equals(OrderStatus.IN_DELIVERING)) {

                if (order.getDeliveryDate().getTime() < currentTime) {
                    receiveRequests.put(UUID.randomUUID().toString(), order);
                }

            }
        }
    }

    private void changeStatusesToExpired() {
        for (Order order : orders) {

            if (order.getOrderStatus().equals(OrderStatus.NEW)) {

                if (order.getDeliveryDate().getTime() < currentTime) {
                    order.setOrderStatus(OrderStatus.EXPIRED);
                }

            }
        }
    }

    public Map<String, Order> getReceiveRequests() {
        return receiveRequests;
    }
}
