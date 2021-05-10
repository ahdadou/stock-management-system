package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
