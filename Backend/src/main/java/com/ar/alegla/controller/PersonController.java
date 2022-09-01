package com.ar.alegla.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ar.alegla.model.Message;
import com.ar.alegla.model.Person;
import com.ar.alegla.service.IPersonService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping(
			value = "allPersons",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> getAllPeople() throws Exception{
		return new ResponseEntity<>(this.personService.findAll(), HttpStatus.OK);
	}
	
	
	@PostMapping(
			value = "findPerson",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> getPersonById(@RequestBody Person p) throws Exception{
		log.info("Searching Person with ID -> " + p.getId());
		Person person = this.personService.findByID(p.getId());
		
		if(person == null) return new ResponseEntity<>(new Message("The Person doesn't exists"), HttpStatus.NOT_FOUND);
		else return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	
	@PostMapping(
			value = "addPerson",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> addNewPerson(@RequestBody Person p) throws Exception{
		this.personService.save(p);
		return new ResponseEntity<>(new Message("The Person was added"), HttpStatus.OK);
	}
	
	
	@PostMapping(
			value = "updatePerson",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updatePerson(@RequestBody Person p) throws Exception{
		int changed = this.personService.update(p);
		return changed != 0? new ResponseEntity<>(new Message("The Person was updated"), HttpStatus.OK) : new ResponseEntity<>(new Message("There was a mistake to update the Person"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PostMapping(
			value = "deletePerson",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> deletePerson(@RequestBody Person p) throws Exception {
		this.personService.delete(p);
		
		return new ResponseEntity<>("The Person was deleted", HttpStatus.OK);
	}

	
}
