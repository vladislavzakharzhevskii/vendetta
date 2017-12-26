package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.dao.UserDAO;
import com.vendettasoft.vendetta.models.hibernate.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;



    @RequestMapping("/getProducts")
    public List<Product> getComputers() {

        Iterable<Product> computerParts = productDAO.findAllByOrderByPkAsc();

        return (List<Product>) computerParts;
    }


    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public Product saveComputer(@ModelAttribute Product product) {

        Product part = productDAO.save(product);

        return part;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public Long deleteProduct(@RequestParam Long productPk) {

        productDAO.delete(productPk);
        return productPk;
    }


}
