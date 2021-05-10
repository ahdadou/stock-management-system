package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.services.SipplierService;
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

@RestController()
public class SupplierController {

	@Autowired
	private SipplierService sipplierService;
	// Add Item

	@PostMapping("/Supplier/add")
	public ResponseEntity<Object> saveItem(@RequestBody Supplier supplier) {
		try {
			sipplierService.saveItem(supplier);
			return new ResponseEntity<>("PRODUCT ADDED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get all Items

	@GetMapping("/Supplier/list")
	public ResponseEntity<Object> getAll() {
		try {
			return new ResponseEntity<>(sipplierService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get Item By Id
	@GetMapping("/Supplier/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(sipplierService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Delete Item By Id

	@DeleteMapping("/Supplier/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable long id) {

		try {
			sipplierService.deleteById(id);
			return new ResponseEntity<>("SUPPLIER DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("SUPLIER DELETION FAILED : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Update Item
	@PutMapping("/Supplier/update")
	public ResponseEntity<Object> updateItem(@RequestBody Supplier supplier) {
		try {
			sipplierService.updateItem(supplier);
			return new ResponseEntity<>("SUPPLIER UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T UPDATE SUPPLIER" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
