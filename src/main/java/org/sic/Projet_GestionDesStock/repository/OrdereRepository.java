package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdereRepository extends JpaRepository<Ordere, Long> {
    @Query(value = "SELECT u.* FROM Ordere u where u.customer_id = :id",nativeQuery = true)
//@Query(value = "SELECT u FROM Ordere u where u.customer = :id")
List<Ordere> getByIdCustomer(@Param("id") long idCustomer);

}
