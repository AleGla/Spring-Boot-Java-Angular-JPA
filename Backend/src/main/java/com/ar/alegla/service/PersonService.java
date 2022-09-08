package com.ar.alegla.service;

import java.util.List;

import com.ar.alegla.model.Person;

public interface PersonService {

public List<Person> findAll() throws Exception;
	
	public Person findByID(int id) throws Exception;
	
	public void save(Person p) throws Exception;
	
	public Integer update(Person p) throws Exception;
	
	public void delete(Person p) throws Exception;
	
	public List<Person> orderLowToHighMoney() throws Exception;
	
	public List<Person> orderHighToLowMoney() throws Exception;
	
	public List<Person> orderLowToHighAge() throws Exception;
	
	public List<Person> orderHighToLowAge() throws Exception;
	
	public List<Person> findPersonByNationality(Person p) throws Exception;
	
	public List<Person> findPersonByNationalityAndOrderLowToHighMoney(Person p) throws Exception;
	
	public List<Person> findPersonByNationalityAndOrderHighToLowMoney(Person p) throws Exception;
	
	public List<Person> findPersonByNationalityAndOrderLowToHighAge(Person p) throws Exception;
	
	public List<Person> findPersonByNationalityAndOrderHighToLowAge(Person p) throws Exception;
	
	public String moneyTransfers(Integer idSender, Integer idReceiver, Integer money) throws Exception;
	
	public List<Person> findAllAvailablePersonToTransfer(Person p) throws Exception;
}
