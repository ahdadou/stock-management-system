package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.services.SipplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SupplierController {

	@Autowired
	private SipplierService sipplierService;
	// Add Item

	@PostMapping("/Supplier/add")
	public Supplier saveItem(@RequestBody Supplier supplier) {
		return sipplierService.saveItem(supplier);
	}

	// Get all Items

	@GetMapping("/Supplier/list")
	public List<Supplier> getAll() {
		return sipplierService.getAll();
	}

	// Get Item By Id
	@GetMapping("/Supplier/{id}")
	public Supplier getById(@PathVariable long id) {
		return sipplierService.getById(id);
	}

	// Delete Item By Id

	@DeleteMapping("/Supplier/{id}")
	public void deleteById(@PathVariable long id) {
		sipplierService.deleteById(id);
	}

	// Update Item
	@PostMapping("/Supplier/update")
	public Supplier updateItem(@RequestBody Supplier supplier) {
		return sipplierService.updateItem(supplier);

	}
}
