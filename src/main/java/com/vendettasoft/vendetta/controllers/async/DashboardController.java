package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.ClientDAO;
import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.util.OrderStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final static Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ClientDAO clientDAO;


    @RequestMapping(value = "/getDashboardData", method = RequestMethod.GET)
    public Map<String, Map<String, Object>> showDashboard() {

        LOGGER.info("Staring collects data for dashboard.");

        Map<String, Map<String, Object>> response = new HashMap<>();
        OrderStatus[] orderStatuses = OrderStatus.values();
        response.put("statuses", new HashMap<>(orderStatuses.length + 1));

        Map<String, Object> statusesHolder = response.get("statuses");
        for (OrderStatus orderStatus : orderStatuses) {
            statusesHolder.put(orderStatus.name(), orderDAO.findByOrderStatusOrderByDeliveryDateDesc(orderStatus));
        }
        statusesHolder.put("allStatuses", orderStatuses);

        //get clients
        Iterable<Order> allOrders = orderDAO.findAll();
        Map<String, Object> clientsHolder = new HashMap<>();
        response.put("clients", clientsHolder);

        for (Order order : allOrders) {
            String key = order.getFirstName() + "&" + order.getLastName();

            if (clientsHolder.get(key) != null) {
                ((List) clientsHolder.get(key)).add(order);
            } else {
                //add new one
                List<Order> newOne = new ArrayList<>();
                newOne.add(order);
                clientsHolder.put(key, newOne);
            }
        }

        clientsHolder.put("allClients", clientsHolder.keySet());


        return response;
    }



}
