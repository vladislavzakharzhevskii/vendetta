package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.Order;
import com.vendettasoft.vendetta.models.util.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderDAO extends CrudRepository<Order, Long>{

    List<Order> findAllByOrderByPkAsc();

    List<Order> findAllByOrderByPkDesc();

    List<Order> findByOrderStatusOrderByDeliveryDateDesc(OrderStatus orderStatus);
}
