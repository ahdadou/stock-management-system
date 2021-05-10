package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandService {

	@Autowired
	SupplierRepository supplierRepository;

//    Add Item
	public SupplierProduct saveItem(SupplierProduct Command) {
		return supplierRepository.save(Command);
	}

//    Get all Items
	public List<SupplierProduct> getAll() {
		return null;
	}

//    Get Item By Id
	public SupplierProduct getById(int id) {
		return null;
	}

//    Delete Item By Id

	public void deleteById() {

	}

//    Update Item
	public SupplierProduct updateItem() {
		return null;
	}

}
