package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<SupplierProduct, Long> {
}
