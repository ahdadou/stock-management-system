package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
