package org.sic.Projet_GestionDesStock.repository;

import java.util.Optional;

import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	Optional<Supplier> findByName(String name);

}
