package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// Optional<Product> findByName(String name);
	// @Query(value = "select p from Category p JOIN p.products where p=: ?1")
	// public Category products(long id);

}
