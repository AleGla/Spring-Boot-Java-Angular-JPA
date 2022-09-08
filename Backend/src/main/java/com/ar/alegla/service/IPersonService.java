package com.ar.alegla.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.alegla.function.MoneyTransfer;
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
						
			Integer changed = this.peopleRepository.updatePerson(e.getId(), e.getName(), e.getLastname(), e.getAge(), e.getMoney(), e.getAddress(), e.getStreetNumber(), e.getNationality() , e.getDni());
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

	@Override
	@Transactional
	public List<Person> orderLowToHighMoney() throws Exception {
		// TODO Auto-generated method stub
			
		try {
			List<Person> listPersonOrdered = this.peopleRepository.getOrderLowToHighMoney();
			log.info("The List was ordered for quantity of money (Low to High)");
			return listPersonOrdered;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}		
	}

	@Override
	@Transactional
	public List<Person> orderHighToLowMoney() throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Person> listPersonOrdered = this.peopleRepository.getOrderHighToLowMoney();
			log.info("The List was ordered for quantity of money (High to Low)");
			return listPersonOrdered;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> orderLowToHighAge() throws Exception {
		// TODO Auto-generated method stub
		
		try {
		List<Person> list = this.peopleRepository.getOrderLowToHighAge();
		log.info("The List was ordered for age (Low to High)");
		return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> orderHighToLowAge() throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Person> list = this.peopleRepository.getOrderHighToLowAge();
			log.info("The List was ordered for age (High to Low)");
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> findPersonByNationality(Person p) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Person> list = this.peopleRepository.findPersonByNationality(p.getNationality());
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> findPersonByNationalityAndOrderLowToHighMoney(Person p) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Person> list = this.peopleRepository.findPersonByNationalityAndOrderLowToHighMoney(p.getNationality());
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> findPersonByNationalityAndOrderHighToLowMoney(Person p) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Person> list = this.peopleRepository.findPersonByNationalityAndOrderHighToLowMoney(p.getNationality());
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		
	}

	@Override
	@Transactional
	public List<Person> findPersonByNationalityAndOrderLowToHighAge(Person p) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Person> list = this.peopleRepository.findPersonByNationalityAndOrderLowToHighAge(p.getNationality());
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> findPersonByNationalityAndOrderHighToLowAge(Person p) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Person> list = this.peopleRepository.findPersonByNationalityAndOrderHighToLowAge(p.getNationality());
			return list;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public String moneyTransfers(Integer idSender, Integer idReceiver, Integer money) throws Exception {		
		// TODO Auto-generated method stub
		
		try {
			Optional<Person> sender = this.peopleRepository.findById(idSender);
			Optional<Person> receiver = this.peopleRepository.findById(idReceiver);
	
			HashMap<String, Person> operation = MoneyTransfer.sendMoney(sender.get(), receiver.get(), money);
			
			
			if(operation == null) return "You don't have sufficient money in your account to do the operation";
			
			Integer idSenderToUpdate = operation.get("sender").getId();
			Integer idReceiverToUpdate = operation.get("receiver").getId();
			Integer senderMoneyTotalToUpdate = operation.get("sender").getMoney();
			Integer receiverMoneyTotalToUpdate = operation.get("receiver").getMoney();

			Integer rowsChanged = this.peopleRepository.moneyTransfers(idSenderToUpdate, idReceiverToUpdate, senderMoneyTotalToUpdate, receiverMoneyTotalToUpdate);
			
			if(rowsChanged == 2) return "ok";
			return "Has been an error to try update the data in the database";
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Person> findAllAvailablePersonToTransfer(Person p) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			
			List<Person> list = this.peopleRepository.findAllAvailablePersonToTransfer(p.getId());
			
			if(list == null) return null;
			else return list;
			
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	

	
	
}
