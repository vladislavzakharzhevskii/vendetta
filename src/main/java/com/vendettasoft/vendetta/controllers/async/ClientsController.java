package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.models.dto.Client;
import com.vendettasoft.vendetta.models.hibernate.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public Set<Client> getAllClients() {
        Iterable<Order> orders = orderDAO.findAll();

        Set<Client> clients = new HashSet<>();
        for (Order order : orders) {
            Client client = new Client();
            client.setFirstName(order.getFirstName());
            client.setLastName(order.getLastName());
            client.setBirthdayDate(order.getBirthdayDate());

            clients.add(client);
        }

        return clients;
    }



}
