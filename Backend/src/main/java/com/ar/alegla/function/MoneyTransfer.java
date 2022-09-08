package com.ar.alegla.function;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ar.alegla.model.Person;

public class MoneyTransfer {

	private static final Logger log = LoggerFactory.getLogger(MoneyTransfer.class);
	
	
	public static HashMap<String,Person> sendMoney(Person sender, Person receiver, Integer money) {				
		
		if(sender.getMoney() < money) {
			return null; 
		}
		
		HashMap<String, Person> dataTransfer = new HashMap<>();

		
		sender.setMoney((sender.getMoney() - money));		
		receiver.setMoney((receiver.getMoney() + money));
	
		
		dataTransfer.put("sender", sender);
		dataTransfer.put("receiver", receiver);
		
		
		return dataTransfer; 
	}
	
	
}
