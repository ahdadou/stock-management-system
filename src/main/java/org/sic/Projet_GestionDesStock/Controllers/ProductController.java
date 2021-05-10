package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	// Add Item
	@PostMapping("/product/add")
	public Product saveItem(@RequestBody Product product) {
		return productService.saveItem(product);
	}

	// Get all Items
	@GetMapping("/product/list")
	public List<Product> getAll() {
		return productService.getAll();
	}

	// Get Item By Id
	@GetMapping("/product/{id}")
	public Product getById(long id) {
		return productService.getById(id);
	}
	// Delete Item By Id

	@DeleteMapping("/product/{id}")
	public void deleteById(@PathVariable long id) {
		productService.deleteById(id);
	}

	// Update Item
	@PostMapping("/product/update")
	public Product updateItem(@RequestBody Product product) {
		return productService.saveItem(product);
	}
}