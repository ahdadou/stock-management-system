package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdereRepository extends JpaRepository<Ordere, Long> {
	@Query(value = "SELECT u.* FROM Ordere u where u.customer_id = :id", nativeQuery = true)
	List<Ordere> getByIdCustomer(@Param("id") long idCustomer);

//    @Query(value = "select sum(o.price*o.quantity) from order_product o where o.ordere_id = id;",nativeQuery = true)
//    double totalPriceforOrder(@Param("id") long idOrder);

	@Query(value = "select sum(o.total) from ordere o", nativeQuery = true)
	double TotalPrice();

	@Query(value = "select sum(o.total) from ordere o where o.customer_id = :id", nativeQuery = true)
	double totalByCustomer(@Param("id") long idCustomer);

}
