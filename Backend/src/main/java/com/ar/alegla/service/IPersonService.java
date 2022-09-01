package com.ar.alegla.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.alegla.model.Person;

@Service
public class IPersonService implements PersonService{
	
	private static final Logger log = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonRepository peopleRepository;
	
	@Override
	@Transactional
	public List<Person> findAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Person> listPeople = this.peopleRepository.findAll();
			log.info("People found-> " + listPeople);
			
			return listPeople;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		
	}

	@Override
	@Transactional
	public Person findByID(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Optional<Person> personById = this.peopleRepository.findById(id);
			
			return !(personById.isPresent())? null : personById.get();
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		
	}

	@Override
	@Transactional
	public void save(Person e) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.peopleRepository.save(e);
			log.info("The Person was saved successfully");
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public Integer update(Person e) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			//Optional<Person> person = this.peopleRepository.findById(e.getId());
			//this.peopleRepository.save(person.get());
			Integer changed = this.peopleRepository.updatePerson(e.getId(), e.getName(), e.getLastname(), e.getAge(), e.getMoney(), e.getAddress(), e.getStreetNumber());
			if(changed != 0) log.info("The Person was updated successfully");
			else log.info("There was a mistake to update the Person");
			
			return changed;		
		}catch(Exception ex ) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public void delete(Person e) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			this.peopleRepository.delete(e);
			log.info("The Person was deleted");
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	
	
}
