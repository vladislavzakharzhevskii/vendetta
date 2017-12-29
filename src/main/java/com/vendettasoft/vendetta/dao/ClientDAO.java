package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.Client;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClientDAO extends CrudRepository<Client, Long> {
}
