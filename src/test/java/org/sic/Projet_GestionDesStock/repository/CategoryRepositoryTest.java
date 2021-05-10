package org.sic.Projet_GestionDesStock.repository;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.sic.Projet_GestionDesStock.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.stream.Stream;


//@DataJpaTest
@SpringBootTest
public class CategoryRepositoryTest {
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//
//    @AfterEach
//    void tearDown() {
//        categoryRepository.deleteAll();
//    }
//
//    @BeforeEach
////    @BeforeAll
//    void tearUp() {
//        Stream.of("aaa","bbb","ccc","ddd")
//                .forEach(c -> categoryRepository.save(new Category(1,c)));
//    }
//
//
//
//    @Test
//    @DisplayName(value = "Fetch Item Test ")
//    void fetchItemTest() {
//        Category categoryByNameEx = categoryRepository.findByName("ccc").orElse(new Category());
//        Assertions.assertEquals("ccc",categoryByNameEx.getName());
//        Assertions.assertEquals(4,categoryRepository.findAll().stream().count());
//    }
//
//    @Test
//    @DisplayName(value = "Delete Item Test ")
//    void deleteItemTest() {
//        Category categoryAct = categoryRepository.findByName("ccc").orElse(null);
//        categoryRepository.delete(categoryAct);
//        Category categoryExc = categoryRepository.findByName("ccc").orElse(null);
//        Assertions.assertEquals(categoryExc,null);
//    }
//
//
//
//




}
