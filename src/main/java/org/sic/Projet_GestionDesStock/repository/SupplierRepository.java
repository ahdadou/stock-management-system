package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	@Query(value = "select distinct p.* from supplier_product s  inner join supplier p on  s.supplier_id = p.id where s.product_id =?", nativeQuery = true)
	public List<Supplier> SupplierByProudctId(long id);

}
