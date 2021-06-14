package org.sic.Projet_GestionDesStock.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.helper.productDetails;
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

	@Query(value = "select new org.sic.Projet_GestionDesStock.helper.productDetails( sum(total)  ,o.orderDate )from Ordere o \r\n"
			+ " where week(o.orderDate,1) = week(CURRENT_TIMESTAMP,1)-1 group by day(o.orderDate) ORDER BY day(o.orderDate) desc")
	List<productDetails> TotalPriceByProducts();

	@Query(value = "select new org.sic.Projet_GestionDesStock.helper.productDetails( p.name ,sum(op.quantity) as nombreProduct)  "
			+ "from OrderProduct op inner join op.product p inner join op.ordere o where week(o.orderDate) = week(CURRENT_TIMESTAMP)-1 group by p.name ORDER BY nombreProduct DESC")
	List<productDetails> TotalProdouctsOrdered();

	@Query(value = "select sum(o.total) from ordere o where Month(o.order_date) = :month", nativeQuery = true)
	double totalByMonth(@PathParam("month") int month);

}
