package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	// Add Item
	public Product saveItem(Product product) {
		return productService.saveItem(product);
	}

//	    Get all Items
	public List<Product> getAll() {
		return productService.getAll();
	}

//	    Get Item By Id
	public Product getById(long id) {
		return productService.getById(id);
	}
//	    Delete Item By Id

	public void deleteById(long id) {
		productService.deleteById(id);

	}

//	    Update Item
	public Product updateItem(Product product) {
		return productService.saveItem(product);
	}

}
