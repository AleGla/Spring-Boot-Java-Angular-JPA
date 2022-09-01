package com.ar.alegla.service;

import java.util.List;

import com.ar.alegla.model.Person;

public interface PersonService {

public List<Person> findAll() throws Exception;
	
	public Person findByID(int id) throws Exception;
	
	public void save(Person e) throws Exception;
	
	public Integer update(Person e) throws Exception;
	
	public void delete(Person e) throws Exception;
}
