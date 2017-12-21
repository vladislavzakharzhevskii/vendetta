package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.ProductOrder;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrderDAO extends CrudRepository<ProductOrder, Long>{

}
