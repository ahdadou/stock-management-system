package org.sic.Projet_GestionDesStock.repository;

import java.util.Optional;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//	Optional<Customer> findByName(String name);

}
