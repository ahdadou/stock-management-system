package org.sic.Projet_GestionDesStock.repository;

import java.util.Optional;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//	Optional<Category> findByName(String name);
}
