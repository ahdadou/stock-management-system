package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<?> getCustomers() {
		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/orders/{id}")
	public ResponseEntity<?> getCustomerOrder(@PathVariable long id) {
		try {
			return new ResponseEntity<>(customerService.getOrdersCustomer(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T GET CUSTOMER ORDERS  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T GET CUSTOMER BY ID  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {
			return new ResponseEntity<>(customerService.saveItem(customer), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD CUSTOMER  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		try {
			customerService.deleteById(id);
			return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		try {
			customer.setId(id);
			Customer cust = customerService.saveItem(customer);
			return new ResponseEntity<>(cust, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD CUSTOMER  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/total/orders/{id}")
	public ResponseEntity<?> getTotalCustomeId(@PathVariable long id) {
		try {
			return new ResponseEntity<>(customerService.getTotalByCustomerId(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("ERROR TOTAL ORDERS  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


	@GetMapping("/totalofcustomers")
	public ResponseEntity<?> totalOfcCstomers(){
		try{
			int sum = customerService.getCount();
			return  new ResponseEntity<>(sum,HttpStatus.OK);
		}catch (Exception ex){
			return  new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
		}
	}

}
