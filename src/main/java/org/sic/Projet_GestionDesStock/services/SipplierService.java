package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SipplierService {
<<<<<<< HEAD
  @Autowired
   private	SupplierRepository supplierRepository;
//    Add Item
=======

	@Autowired
	private SupplierRepository supplierRepository;
	// Add Item

>>>>>>> 5f571dbb7929858e08a8e53c99259850ce889f15
	public Supplier saveItem(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	// Get all Items

	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

<<<<<<< HEAD
//    Get Item By Id
	public Supplier getById(long id) {
		return supplierRepository.findById(id).get();
	}
=======
	// Get Item By Id
>>>>>>> 5f571dbb7929858e08a8e53c99259850ce889f15

	public Supplier getById(long id) {
		return supplierRepository.findById(id).get();
	}

<<<<<<< HEAD
	public void deleteById(long id) {
    supplierRepository.deleteById(id);
	}

//    Delete Item By Id
	public void delete(Supplier supplier) {
		supplierRepository.delete(supplier);
	}

//    Update Item
//	public Supplier updateItem() {
//		return null;
//	}
=======
	// Delete Item By Id

	public void deleteById(long id) {
		supplierRepository.deleteById(id);
	}

	// Update Item

	public Supplier updateItem(Supplier supplier) {
		return supplierRepository.save(supplier);
>>>>>>> 5f571dbb7929858e08a8e53c99259850ce889f15

	}
}
