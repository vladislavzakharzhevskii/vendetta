package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.OrderDAO;
import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.dao.UserDAO;
import com.vendettasoft.vendetta.models.hibernate.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    //todo use enum instead
    private static final String BASE_TYPE = "Base";
    private static final String ADDITIONAL_TYPE = "Additional";

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;


    @RequestMapping("/getComputers")

    public List<Product> getComputers() {

        Iterable<Product> computerParts = productDAO.findAllByOrderByPkAsc();

        return (List<Product>) computerParts;
    }


    @RequestMapping(value = "/getParsedComputerParts", method = RequestMethod.POST)
    public Map<String, List<Product>> getParsedComputers() {

        Iterable<Product> computerParts = productDAO.findAll();

        Map<String, List<Product>> parts = new HashMap<>(2);
        parts.put(BASE_TYPE, new ArrayList<>());
        parts.put(ADDITIONAL_TYPE, new ArrayList<>());

        for (Product part : computerParts) {
            List<Product> list = parts.get(part.getType());
            if (list != null) {
                list.add(part);
            }
        }

        return parts;
    }


    @RequestMapping(value = "/saveComputerPart", method = RequestMethod.POST)
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
