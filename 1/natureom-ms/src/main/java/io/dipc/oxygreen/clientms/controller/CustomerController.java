package io.dipc.oxygreen.clientms.controller;

//this is a controller file
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dipc.oxygreen.clientms.exception.ResourceNotFoundException;
import io.dipc.oxygreen.clientms.model.Customer;
import io.dipc.oxygreen.clientms.validator.CustomerValidator;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerValidator customervalid;

	/**
	 * show all the users information
	 * 
	 * @return
	 */
	
	/*@PostMapping("/")
	public ResponseEntity<Customer> checkEmail(@Valid @PathVariable(value = "email") String emailId)
			throws ResourceNotFoundException {
		return customervalid.readCustomer(customerId);
	}*/
	
	@GetMapping("/")
	public List<Customer> readAllCustomers() {
		return customervalid.readAllCustomer();
	}

	/**
	 * show customer information
	 * 
	 * @param customerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> readCustomer(@PathVariable(value = "customerId") long customerId)
			throws ResourceNotFoundException {
		return customervalid.readCustomer(customerId);
	}

	/**
	 * create customer
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/")
	public Object addCustomer(@Valid @RequestBody Customer customer) {
		return customervalid.addCustomer(customer);
	}

	/**
	 * editcustomer
	 * 
	 * @param customerId
	 * @param customerDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> editCustomer(@PathVariable(value = "customerId") long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		return customervalid.editCustomer(customerDetails, customerId);
	}

	/**
	 * deactive customer from the database
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "customerId") long customerId)
			throws Exception {
		return customervalid.deleteCustomer(customerId);
	}

}
