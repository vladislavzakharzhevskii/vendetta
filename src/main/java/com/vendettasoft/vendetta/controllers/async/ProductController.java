package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.dao.ProductImageDAO;
import com.vendettasoft.vendetta.models.hibernate.Product;
import com.vendettasoft.vendetta.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {


    private final static Logger LOGGER = Logger.getLogger(ProductController.class);


    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductImageDAO productImageDAO;

    @Autowired
    private ProductService productService;


    @RequestMapping("/getProducts")
    public List<Product> getComputers() {

        Iterable<Product> products = productDAO.findAllByOrderByPkAsc();

        return (List<Product>) products;
    }


    /*TODO FIGURED OUT WHY SPRING CAN"T CONSTRUCT MODEL WITH files*/
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public Product saveProduct(@RequestParam(value = "files[]", required = false) MultipartFile[] files,
                                @RequestParam(value = "productPk", required = false) Long pk,
                                @RequestParam("productName") String productName,
                                @RequestParam("productDescription") String productDescription,
                                @RequestParam("productCost") Double productCost) throws IOException {

        Product product = new Product();

        if (pk != null) {
            product = productDAO.findOne(pk);
        }

        product.setName(productName);
        product.setCost(productCost);
        product.setDescription(productDescription);

        productService.processAddProduct(product, files);

        return product;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public Long deleteProduct(@RequestParam Long productPk) {

        productDAO.delete(productPk);
        return productPk;
    }

    @RequestMapping(value = "/deleteProductImage", method = RequestMethod.GET)
    public Long deleteProductImage(@RequestParam Long productImagePk) {
        Product product = productDAO.getProductByImage(productImagePk);

        //todo figured out
        //productImageDAO.delete(productImage);

        product.getProductImages().remove(productImageDAO.findOne(productImagePk));
        productDAO.save(product);

        return productImagePk;
    }

}
