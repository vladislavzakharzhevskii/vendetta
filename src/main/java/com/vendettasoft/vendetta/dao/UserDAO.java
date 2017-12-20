package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<User, Long> {
}
