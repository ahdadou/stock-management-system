package org.sic.Projet_GestionDesStock.repository;

import java.util.List;
import java.util.function.Supplier;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Long> {

	// get all products of a Supplier

	@Query(value = "SELECT p.* FROM Supplier_Product Sp inner join Product p on p.id = Sp.Product_id where Sp.Product_id = ?1", nativeQuery = true)
	List<Product> getProductsBySupplier(long idSupplier);
	// get all Suppliers of a Product

	@Query(value = "SELECT S.* FROM Supplier_Product Sp inner join Supplier S on S.id = Supplier_id where Sp.Product_id = ?1", nativeQuery = true)
	List<Supplier> getSuppliersByPoduct(long idPoduct);

}
