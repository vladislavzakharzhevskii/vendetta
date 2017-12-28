package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.ProductImage;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProductImageDAO extends CrudRepository<ProductImage, Long>{


}
