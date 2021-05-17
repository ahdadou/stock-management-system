package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    @Query(value = "select u.* from order_product u where u.ordere_id = :id",nativeQuery = true)
    List<OrderProduct> getByIdOrder(@Param("id") long id);

    void deleteByOrdere_id(long id);

}
