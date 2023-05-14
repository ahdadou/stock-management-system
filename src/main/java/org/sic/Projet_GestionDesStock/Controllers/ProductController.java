package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.sic.Projet_GestionDesStock.services.SupplierService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()

public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private SupplierProductService SupplierProductService;

	// Add Item
	@PostMapping(value = "product/add")
	public ResponseEntity<Object> saveItem(@RequestParam("Product") String product,
			@RequestParam("Supplier") long idSupplier

	) throws JsonProcessingException {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Product p = objectMapper.readValue(product, Product.class);
			double price = p.getPrice();
			int quantity = p.getQuantityStock();
			Product produit = productService.saveItem(p);
			Supplier S = supplierService.getById(idSupplier);
			SupplierProduct SP = new SupplierProduct(produit, S, price, quantity, null);
			SupplierProductService.saveItem(SP);
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
			Product product = productService.getById(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
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
		productService.saveItem(product);
		System.out.print(product.getName());

		try {
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>("CAN'T UPDATE PRODUCT" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/category/{id}")
	public ResponseEntity<Object> getByIdCategory(@PathVariable long id) {
		try {
			return new ResponseEntity<>(productService.getByIdCategory(id), HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/supplier/{id}")
	public ResponseEntity<Object> ProudctBYSupplierId(@PathVariable long id) {
		try {
			return new ResponseEntity<>(productService.ProudctBYSupplierId(id), HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}