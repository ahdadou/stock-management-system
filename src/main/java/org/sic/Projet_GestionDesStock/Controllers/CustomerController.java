package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "")
	public ResponseEntity<?> getCustomers() {

		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/orders/{id}")
	public ResponseEntity<?> getCustomerOrder(@PathVariable long id) {
		try {

			List<Ordere> listOrder = customerService.getOrdersCustomer(id);
			return new ResponseEntity<>(listOrder, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T GET CUSTOMER ORDERS  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable long id) {
		try {

			Customer customer = customerService.getById(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T GET CUSTOMER BY ID  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping("")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {

			Customer res = customerService.saveItem(customer);
//            res.setCreateDate(new Date());
			return new ResponseEntity<>(res, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD CUSTOMER  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		try {
			customerService.deleteById(id);
			return new ResponseEntity<>(new Customer(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> addCustomer(@PathVariable long id, @RequestBody Customer customer) {
		try {
//            res.setAddress(customer.getAddress());
//            res.setEmail(customer.getEmail());
//            res.setFirstname(customer.getFirstname());
//            res.setLastname(customer.getLastname());
//            res.setPhone(customer.getPhone());
			customer.setId(id);

			Customer cust = customerService.saveItem(customer);
//            res.setCreateDate(new Date());
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

}
