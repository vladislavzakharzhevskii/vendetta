package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.hibernate.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {

    void processAddProduct(Product product, MultipartFile[] multipartFiles) throws IOException;
}

