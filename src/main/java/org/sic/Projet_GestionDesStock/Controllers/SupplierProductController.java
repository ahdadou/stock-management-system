package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.services.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SupplierProductController {
	@Autowired
	private SupplierProductService supplierProductService;

	// Add Item

	@PostMapping(value = "/SP/add")
	public SupplierProduct saveItem(@RequestBody SupplierProduct supplierProduct) {
		return supplierProductService.saveItem(supplierProduct);
	}

	// Get all Items
	@GetMapping(value = "/SupplierProduct/list")
	public List<SupplierProduct> getAll() {
		return supplierProductService.getAll();
	}

	// Get Item By Id

	@GetMapping(value = "/SupplierProduct/{id}")
	public SupplierProduct getById(@PathVariable long id) {
		return supplierProductService.getById(id);
	}

	// Delete Item By Id
	@DeleteMapping(value = "/SupplierProduct/{id}")
	public void deleteById(@PathVariable long id) {
		supplierProductService.deleteById(id);
	}

	// Update Item
	@PostMapping(value = "/SupplierProduct/update")
	public SupplierProduct updateItem(@RequestBody SupplierProduct supplierProduct) {
		return supplierProductService.updateItem(supplierProduct);
	}

}
