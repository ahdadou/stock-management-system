package org.sic.Projet_GestionDesStock.services;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.helper.SupplierDetails;
import org.sic.Projet_GestionDesStock.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

	Logger logger = LoggerFactory.getLogger(SupplierService.class);

	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier saveItem(Supplier supplier) {
		logger.info("Saving supplier");
		return supplierRepository.save(supplier);
	}

	public List<Supplier> getAll() {
		logger.info("Getting all suppliers");
		return supplierRepository.findAll();
	}

	public Supplier getById(long id) {
		logger.info("Getting supplier by id");
		return supplierRepository.findById(id).get();
	}

	public void deleteById(long id) {
		logger.info("Deleting supplier by id");
		supplierRepository.deleteById(id);
	}

	public Supplier updateItem(Supplier supplier) {
		logger.info("Updating supplier");
		return supplierRepository.save(supplier);

	}

	public List<SupplierDetails> SupplierByProudctId(long idProudct) {
		logger.info("Getting supplier by proudct id");
		return supplierRepository.SupplierByProudctId(idProudct);

	}

	public int getCount() {
		return supplierRepository.getCount();
	}
}
