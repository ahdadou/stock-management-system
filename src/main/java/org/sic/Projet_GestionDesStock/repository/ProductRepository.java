package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// Optional<Product> findByName(String name);
	@Query(value = "select p from Category p JOIN p.products c where c.id=:id")
	public Category products(long id);

	@Query(value = "select distinct p.* from supplier_product s  inner join product p on  s.product_id = p.id where s.supplier_id =?1", nativeQuery = true)
	public List<Product> ProudctBYSupplierId(long id);

}
