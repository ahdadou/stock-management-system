package org.sic.Projet_GestionDesStock.repository;

import java.util.Optional;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select count(*) from customer",nativeQuery = true)
    int getCount();
//	Optional<Customer> findByName(String name);

}
