package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin(value = "http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService productService;

	// Add Item
	@PostMapping(value = "product/add")
	public ResponseEntity<Object> saveItem(@RequestBody Product product) {
		try {
			productService.saveItem(product);
			return new ResponseEntity<>("PRODUCT ADDED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get all Items
	@GetMapping(value = "/list-product")
	public ResponseEntity<Object> getAll() {
		try {
			return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get Item By Id
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id) {
		try {
			Product poduit = productService.getById(id);
			return new ResponseEntity<>(poduit, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/edit/{id}")
	public ResponseEntity<Object> getByIdCategory(@PathVariable Long id) {
		try {
			Product cat = productService.getById(id);
			return new ResponseEntity<>(cat, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	// Delete Item By Id

	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable long id) {
		try {
			productService.deleteById(id);
			return new ResponseEntity<>("PRODUCT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("PRODUCT DELITION FAILED : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Update Item
	@PutMapping(value = "/product/update")
	public ResponseEntity<Object> updateItem(@RequestBody Product product) {
		try {
			productService.saveItem(product);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>("CAN'T UPDATE PRODUCT" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/category/{id}")
	public Category getByIdCategory(@PathVariable long id) {
		return productService.getByIdCategory(id);
	}

	@GetMapping(value = "/product/supplier/{id}")
	public List<Product> ProudctBYSupplierId(@PathVariable long id) {
		return productService.ProudctBYSupplierId(id);
	}
}