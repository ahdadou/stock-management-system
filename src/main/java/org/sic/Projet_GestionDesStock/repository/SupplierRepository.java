package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.helper.SupplierDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query(value = "select new org.sic.Projet_GestionDesStock.helper.SupplierDetails(p.id,p.firstname  , p.lastname,s.price, s.quantity,s.operationDate) from SupplierProduct s inner join s.supplier p  where s.product.id = :id")
    List<SupplierDetails> SupplierByProudctId(@Param("id") long id);

	@Query(value = "select count(*) from supplier",nativeQuery = true)
	int getCount();
}
