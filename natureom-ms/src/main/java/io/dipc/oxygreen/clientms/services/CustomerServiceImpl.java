package io.dipc.oxygreen.clientms.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.dipc.oxygreen.clientms.dao.CustomerDao;
import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public ResponseEntity<Customer> addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	public ResponseEntity<Customer> editCustomer(Customer customer, long customerId) throws ResourceNotFoundException {
		return customerDao.editCustomer(customerId, customer);
	}

	public ResponseEntity<Customer> deleteCustomer(long customerId) throws Exception {
		return customerDao.deleteCustomer(customerId);
	}

	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException {
		return customerDao.readCustomer(customerId);
	}

	public List<Customer> readAllCustomer() {
		return customerDao.readAllCustomer();
	}
	
	  @Override public Customer checkEmail(@Valid String emailId) throws
	  ResourceNotFoundException { return customerDao.checkEmail(emailId);
	  
	  }
	 

}
