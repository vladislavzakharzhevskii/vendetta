package com.vendettasoft.vendetta.dao;

import com.vendettasoft.vendetta.models.hibernate.ComputerPart;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ComputerDao extends CrudRepository<ComputerPart, Long>{}