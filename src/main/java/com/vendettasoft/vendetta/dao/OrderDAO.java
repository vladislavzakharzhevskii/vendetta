package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.Order;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Long>{}
