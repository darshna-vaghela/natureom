package io.dipc.oxygreen.clientms.validator;

//this file for the business logic
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.dipc.oxygreen.clientms.dao.CustomerDao;
import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;
import io.dipc.oxygreen.clientms.repository.CustomerRepository;
import io.dipc.oxygreen.clientms.services.CustomerService;

@Component
public class CustomerValidator {
	@Autowired
	CustomerService customerService;
	@Autowired
	private CustomerRepository customerRepository;
	private CustomerDao customerDao;

	/**
	 * create customer
	 * 
	 * @param customer
	 * @return
	 */
	public ResponseEntity<Customer> addCustomer(Customer customer) {
		return customerService.addCustomer(customer);
	}

	/**
	 * edit customer's data
	 * 
	 * @param customer
	 * @param customerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<Customer> editCustomer(Customer customer, long customerId) throws ResourceNotFoundException {
		return customerService.editCustomer(customer, customerId);
	}

	/**
	 * deactive the customer form the database
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<Customer> deleteCustomer(long customerId) throws Exception {
		return customerService.deleteCustomer(customerId);
	}

	/**
	 * show all the data of customer
	 * 
	 * @param customerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<Customer> readCustomer(long customerId) throws ResourceNotFoundException {
		return customerService.readCustomer(customerId);
	}

	/**
	 * show data of all the customer
	 * 
	 * @return
	 */

	public List<Customer> readAllCustomer() {
		return customerService.readAllCustomer();
	}

	public ResponseEntity<Customer> checkEmail(@Valid String emailId, Customer customer)
			throws ResourceNotFoundException
	{
		Customer tempemail = customerService.checkEmail(emailId);
		
		if (tempemail == null) 
		{
			return customerService.addCustomer(customer);
		} 
		else
		{
			long tid = customerDao.findCustIdByEmail(emailId, customer);
			return customerService.editCustomer(customer, tid);
		}
	}

}
