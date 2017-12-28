package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductDAO extends CrudRepository<Product, Long>{

    List<Product> findAllByOrderByPkAsc();


    @Query("SELECT product from Product as product " +
            "INNER JOIN product.productImages as productImages WHERE productImages.pk = :imPk")
    Product getProductByImage(@Param("imPk") Long imagePk);
}