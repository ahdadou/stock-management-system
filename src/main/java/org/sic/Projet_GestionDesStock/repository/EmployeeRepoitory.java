package org.sic.Projet_GestionDesStock.repository;

import java.util.Optional;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepoitory extends JpaRepository<Employee, Long> {
	Optional<Category> findByFirstname(String Role);

}
