package ma.suppliers.controllers;

import ma.suppliers.entities.Suppliers;
import ma.suppliers.services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/supplier")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return suppliersService.getAllSuppliers();
    }

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String value;



    @GetMapping("/test")
    private String test(){
        return value;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable String id) {
        Optional<Suppliers> supplier = suppliersService.getSupplierById(id);
        if (supplier.isPresent()) {
            return ResponseEntity.ok(supplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Suppliers> createSupplier(@RequestBody Suppliers supplier) {
        Suppliers createdSupplier = suppliersService.createSupplier(supplier);
        return ResponseEntity.created(URI.create("/api/suppliers/" + createdSupplier.getId()))
                .body(createdSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> updateSupplier(@PathVariable String id, @RequestBody Suppliers supplier) {
        Suppliers updatedSupplier = suppliersService.updateSupplier(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String id) {
        suppliersService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}