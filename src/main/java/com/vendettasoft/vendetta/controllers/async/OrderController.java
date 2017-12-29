package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.models.dto.OrdersDTO;
import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.util.OrderStatus;
import com.vendettasoft.vendetta.services.OrderService;
import com.vendettasoft.vendetta.utils.binders.DateWithTimePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public String submitComputerOrder(@ModelAttribute Order orderDTO) {

        orderService.submitOrder(orderDTO);

        return "has-ordered_" + "order_pk";
    }


    @RequestMapping(value = "/getProductOrders", method = RequestMethod.GET)
    public OrdersDTO getOrders() {
        return orderService.findAllByOrderByPkDesc();
    }


    @RequestMapping(value = "/changeOrdersStatus", method = RequestMethod.POST)
    public void changeOrderStatus(@RequestParam("pk") Order order,
                                  @RequestParam("newOrderStatus") String newStatus) {

        order.setOrderStatus(OrderStatus.valueOf(newStatus));

        orderDAO.save(order);
    }





    @InitBinder
    public void init(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, "deliveryDate", new DateWithTimePropertyEditor());

    }

}
