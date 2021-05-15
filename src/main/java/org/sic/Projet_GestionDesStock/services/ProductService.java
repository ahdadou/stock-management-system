package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;

	// Add Item
	public Product saveItem(Product product) {
		return productRepository.save(product);
	}

	// Get all Items
	public List<Product> getAll() {

		return productRepository.findAll();
	}

	// Get Item By Id
	public Product getById(long id) {
		return productRepository.findById(id).get();
	}

	public Category getByIdCategory(long id) {
		return productRepository.products(id);
	}

	// Delete Item By Id

	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

	// Update Item
	public Product updateItem(Product product) {
		return productRepository.save(product);
	}

	public List<Product> ProudctBYSupplierId(long id) {
		return productRepository.ProudctBYSupplierId(id);
	}

}
