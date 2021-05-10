package org.sic.Projet_GestionDesStock.repository;

import org.junit.jupiter.api.*;
import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;


//    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

//    @BeforeEach
//    @BeforeAll
    void tearUp() {
        Stream.of("aaa","bbb","ccc","ddd")
                .forEach(c -> {
                    Product product = new Product(1,c,null, 100+new Random().nextDouble()*1000,null,null,null,100+new Random().nextInt()*1000,null);
                    productRepository.save(product);
                });
    }



    @Test
    @DisplayName(value = "Fetch Item Test ")
    void fetchItemTest() {
        Stream.of("aaa","bbb","ccc","ddd")
                .forEach(c -> {
                    Product product = new Product(1,c,null, 100+new Random().nextDouble()*1000,null,null,null,100+new Random().nextInt()*1000,null);
                    productRepository.save(product);
                });
        Assertions.assertEquals(4,productRepository.findAll().stream().count());
    }

    @Test
    @DisplayName(value = "Delete Item Test ")
    void deleteItemTest() {
        Product productAct = productRepository.findByName("ccc").orElse(null);
        productRepository.delete(productAct);
        Product productExc = productRepository.findByName("ccc").orElse(null);
        Assertions.assertEquals(productExc,null);
    }



}
