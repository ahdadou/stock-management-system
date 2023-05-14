package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(value = "*")
public class SupplierController {

	@Autowired
	private SupplierService sipplierService;

	@PostMapping("/Supplier/add")
	public ResponseEntity<Object> saveItem(@RequestBody Supplier supplier) {
		try {
			return new ResponseEntity<>(sipplierService.saveItem(supplier), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/Supplier/list")
	public ResponseEntity<Object> getAll() {
		try {
			return new ResponseEntity<>(sipplierService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Supplier/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(sipplierService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

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
			return new ResponseEntity<>(sipplierService.updateItem(supplier), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T UPDATE SUPPLIER" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Supplier/product/{id}")
	public ResponseEntity<Object> SupplierByProudctId(@PathVariable long id) {
		try {
			return new ResponseEntity<>(sipplierService.SupplierByProudctId(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/supplier/totalofsupplier")
	public ResponseEntity<?> totalOfcCstomers(){
		try{
			return  new ResponseEntity<>(sipplierService.getCount(),HttpStatus.OK);
		}catch (Exception ex){
			return  new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
		}
	}
}
