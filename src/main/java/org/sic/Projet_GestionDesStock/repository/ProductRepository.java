package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.helper.SupplierDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// Optional<Product> findByName(String name);
	@Query(value = "select p from Category p JOIN p.products c where c.id=:id")
	public Category products(long id);

	@Query(value = "select new org.sic.Projet_GestionDesStock.helper.SupplierDetails( s.name,p.price, p.quantity,p.operationDate) from SupplierProduct p inner join p.product s where p.supplier.id = :id")
	public List<SupplierDetails> ProudctBYSupplierId(@Param("id") long id);

}
