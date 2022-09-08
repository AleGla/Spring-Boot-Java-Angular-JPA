package com.ar.alegla.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ar.alegla.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Modifying
	@Query("UPDATE Person SET name = :name, last_name = :lastname, age = :age, money = :money, address = :address, street_number = :streetNumber, nationality = :nationality , dni = :dni WHERE id_person = :id")
	public Integer updatePerson(@Param("id")Integer id,@Param("name") String name,@Param("lastname") String lastname,@Param("age") String age,@Param("money") Integer money,@Param("address") String address,@Param("streetNumber") String streetNumber, @Param("nationality") String nationality , @Param("dni") String dni) throws Exception;
	
	
	@Query("Select p from Person as p order by p.money")
	public List<Person> getOrderLowToHighMoney() throws Exception;
	
	@Query("Select p from Person as p order by p.money DESC")
	public List<Person> getOrderHighToLowMoney() throws Exception;
	
	@Query("Select p from Person as p order by p.age")
	public List<Person> getOrderLowToHighAge() throws Exception;
	
	@Query("Select p from Person as p order by p.age DESC")
	public List<Person> getOrderHighToLowAge() throws Exception;
	
	@Query("Select p from Person as p where nationality = :nationality")
	public List<Person> findPersonByNationality(@Param("nationality") String nationality) throws Exception;
	
	@Query("Select p from Person as p where nationality = :nationality order by p.money")
	public List<Person> findPersonByNationalityAndOrderLowToHighMoney(@Param("nationality") String nationality) throws Exception;
	
	@Query("Select p from Person as p where nationality = :nationality order by p.money DESC")
	public List<Person> findPersonByNationalityAndOrderHighToLowMoney(@Param("nationality") String nationality) throws Exception;
	
	@Query("Select p from Person as p where nationality = :nationality order by p.age")
	public List<Person> findPersonByNationalityAndOrderLowToHighAge(@Param("nationality") String nationality) throws Exception;
	
	@Query("Select p from Person as p where nationality = :nationality order by p.age DESC")
	public List<Person> findPersonByNationalityAndOrderHighToLowAge(@Param("nationality") String nationality) throws Exception;
	
	@Modifying
	@Query("UPDATE Person SET money = CASE id_person WHEN :idSender THEN :senderMoneyTotal WHEN :idReceiver THEN :receiverMoneyTotal END WHERE id_person IN(:idSender, :idReceiver)")
	public Integer moneyTransfers(@Param("idSender") Integer idSender, @Param("idReceiver") Integer idReceiver, @Param("senderMoneyTotal") Integer senderMoneyTotal, @Param("receiverMoneyTotal") Integer receiverMoneyTotal) throws Exception;

	@Query("Select p from Person as p where id_person != :idReceiver")
	public List<Person> findAllAvailablePersonToTransfer(@Param("idReceiver") Integer idReceiver) throws Exception;

}
