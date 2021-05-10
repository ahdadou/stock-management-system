package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.services.SupplierProductService;
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
public class SupplierProductController {
	@Autowired
	private SupplierProductService supplierProductService;

	// Add Item

	@PostMapping(value = "/SupplierProduct/add")
	public ResponseEntity<Object> saveItem(@RequestBody SupplierProduct supplierProduct) {
		try {
			supplierProductService.saveItem(supplierProduct);
			return new ResponseEntity<>("ORDER ADDED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get all Items
	@GetMapping(value = "/SupplierProduct/list")
	public ResponseEntity<Object> getAll() {
		try {
			return new ResponseEntity<>(supplierProductService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get Item By Id

	@GetMapping(value = "/SupplierProduct/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(supplierProductService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Delete Item By Id
	@DeleteMapping(value = "/SupplierProduct/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable long id) {
		try {
			supplierProductService.deleteById(id);
			return new ResponseEntity<>("ORDER DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	// Update Item
	@PutMapping(value = "/SupplierProduct/update")
	public ResponseEntity<Object> updateItem(@RequestBody SupplierProduct supplierProduct) {
		try {
			supplierProductService.updateItem(supplierProduct);
			return new ResponseEntity<>("ORDER UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ORDER SUPPLIER" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
