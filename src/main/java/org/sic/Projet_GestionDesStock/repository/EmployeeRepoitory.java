package org.sic.Projet_GestionDesStock.repository;

import org.sic.Projet_GestionDesStock.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepoitory extends JpaRepository<Employee, Long> {
//	Optional<Category> findByRole(String Role);
	Employee findByName(String username);

}
