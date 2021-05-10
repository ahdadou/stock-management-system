
package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.repository.SupplierProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierProductService {

	@Autowired
	private SupplierProductRepository supplierProductRepository;

	// Add Item
	public SupplierProduct saveItem(SupplierProduct supplierProduct) {
		return supplierProductRepository.save(supplierProduct);
	}

	// Get all Items
	public List<SupplierProduct> getAll() {
		return supplierProductRepository.findAll();
	}

	// Get Item By Id
	public SupplierProduct getById(long id) {
		return supplierProductRepository.findById(id).get();
	}

	// Delete Item By Id

	public void deleteById(long id) {
		supplierProductRepository.deleteById(id);

	}

	// Update Item
	public SupplierProduct updateItem(SupplierProduct supplierProduct) {
		return supplierProductRepository.save(supplierProduct);

	}

}
