package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.helper.SupplierDetails;
import org.sic.Projet_GestionDesStock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SipplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier saveItem(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	// Get all Items

	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

	public Supplier getById(long id) {
		return supplierRepository.findById(id).get();
	}

	// Delete Item By Id

	public void deleteById(long id) {
		supplierRepository.deleteById(id);
	}

	// Update Item

	public Supplier updateItem(Supplier supplier) {
		return supplierRepository.save(supplier);

	}

	public List<SupplierDetails> SupplierByProudctId(long idProudct) {
		return supplierRepository.SupplierByProudctId(idProudct);

	}

	public int getCount() {
		return supplierRepository.getCount();
	}
}
