package io.dipc.oxygreen.clientms.dao;

//dao file
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;

public interface CustomerDao {
	public Customer addCustomer(Customer customer);

	public ResponseEntity<Customer> deleteCustomer(long customerId) throws Exception;

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException;

	public List<Customer> readAllCustomer();

	public ResponseEntity<Customer> editCustomer(long customerId, @Valid Customer customerDetails)
			throws ResourceNotFoundException;

}
