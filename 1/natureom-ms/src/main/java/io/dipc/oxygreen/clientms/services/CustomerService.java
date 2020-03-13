package io.dipc.oxygreen.clientms.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;

//user service file
@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public ResponseEntity<Customer> editCustomer(Customer customer, long customerId) throws ResourceNotFoundException;

	public ResponseEntity<Customer> deleteCustomer(long customerId) throws Exception;

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException;

	public List<Customer> readAllCustomer();

}
