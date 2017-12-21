package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.Product;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductDAO extends CrudRepository<Product, Long>{

    List<Product> findAllByOrderByPkAsc();

}