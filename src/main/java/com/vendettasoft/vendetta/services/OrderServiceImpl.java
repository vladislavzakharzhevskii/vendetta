package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.UserDAO;
import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.hibernate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void submitOrder(User user, Long basePart, List<Long> additionalParts) {

        /*save user*/
//        userDAO.save(user);

        /*save order*/
        Order order = new Order();
//        order.setOwner(user);

//        order.setTotalSum(666.00);


        orderDAO.save(order);
    }
}
