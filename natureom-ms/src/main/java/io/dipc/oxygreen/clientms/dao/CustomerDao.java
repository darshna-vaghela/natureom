package io.dipc.oxygreen.clientms.dao;

//dao file
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;

public interface CustomerDao {
	public ResponseEntity<Customer> addCustomer(Customer customer);

	public ResponseEntity<Customer> deleteCustomer(long customerId) throws Exception;

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException;

	public List<Customer> readAllCustomer();

	public ResponseEntity<Customer> editCustomer(long customerId, @Valid Customer customerDetails)
			throws ResourceNotFoundException;

 public Customer checkEmail(@Valid String emailId)throws ResourceNotFoundException;

	/* public Customer findCustomerIdByEmail(@Valid String emailId); */
	
	public long findCustIdByEmail(String emailId ,@Valid Customer customerDetails) throws ResourceNotFoundException;

}
