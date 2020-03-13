package io.dipc.oxygreen.clientms.repository;

import javax.validation.Valid;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.dipc.oxygreen.clientms.model.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	/*
	 * @Query("SELECT t.customer_id FROM tbl_customers t WHERE t.email= ?1")
	 * Customer findCustomerIdByEmailId(String emailId);
	 */
	  
	/*
	 * @Query("SELECT a.customer_id FROM tbl_customers a WHERE email = :email")
	 * Customer findCustomerIdByEmailId(@Param("email") String email);
	 */
	  
	  
	  
	  Customer findByEmail(@Valid String emailId);
	 

}
 