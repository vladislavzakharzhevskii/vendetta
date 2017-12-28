package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.dao.ProductDAO;
import com.vendettasoft.vendetta.models.hibernate.Product;
import com.vendettasoft.vendetta.models.hibernate.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void processAddProduct(Product product, MultipartFile[] multipartFiles) throws IOException {

        //save product to be created with id
        productDAO.save(product);

        List<ProductImage> images = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {

            final ProductImage productImage = new ProductImage();

            productImage.setName(multipartFile.getOriginalFilename());
            productImage.setDescription("Add Description here.");
            productImage.setCreatedDate(new Date());
            productImage.setLob(multipartFile.getBytes());
            productImage.setContentType(multipartFile.getContentType());
            productImage.setProduct(product);

            images.add(productImage);
        }

        List<ProductImage> productImages = product.getProductImages();
        if (productImages != null) {
            productImages.addAll(images);
        } else {
            product.setProductImages(images);
        }

        productDAO.save(product);
    }
}
