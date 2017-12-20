package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.models.dto.ComputerOrderDTO;
import com.vendettasoft.vendetta.models.hibernate.User;
import com.vendettasoft.vendetta.services.OrderService;
import com.vendettasoft.vendetta.utils.mvceditors.UserCustomEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/submitComputerOrder", method = RequestMethod.POST)
    public String submitComputerOrder(@ModelAttribute ComputerOrderDTO orderDTO) {

        orderService.submitOrder(orderDTO.getUser(), orderDTO.getBaseComponentId(), orderDTO.getAdditionalComponentsIds());

        return "has-ordered_" + "order_pk";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new UserCustomEditor());
    }
}
