package com.ar.alegla.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ar.alegla.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Modifying
	@Query("UPDATE Person SET name = :name, last_name = :lastname, age = :age, money = :money, address = :address, street_number = :streetNumber WHERE id_person = :id")
	public Integer updatePerson(@Param("id")Integer id,@Param("name") String name,@Param("lastname") String lastname,@Param("age") String age,@Param("money") Integer money,@Param("address") String address,@Param("streetNumber") String streetNumber) throws Exception;
	
	
	
}
