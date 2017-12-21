package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.models.hibernate.ProductOrder;
import com.vendettasoft.vendetta.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/submitComputerOrder", method = RequestMethod.POST)
    public String submitComputerOrder(@ModelAttribute ProductOrder productOrderDTO) {

        orderService.submitOrder(productOrderDTO);

        return "has-ordered_" + "order_pk";
    }


    @RequestMapping(value = "/getProductOrders", method = RequestMethod.GET)
    public List<ProductOrder> getOrders() {
        return (List<ProductOrder>) orderDAO.findAll();
    }


}
