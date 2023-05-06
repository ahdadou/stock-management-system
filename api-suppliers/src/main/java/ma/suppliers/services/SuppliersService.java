package ma.suppliers.services;

import ma.suppliers.entities.Suppliers;
import ma.suppliers.exceptions.ResourceNotFoundException;
import ma.suppliers.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    public Optional<Suppliers> getSupplierById(String id) {
        return suppliersRepository.findById(id);
    }

    public Suppliers createSupplier(Suppliers supplier) {
        return suppliersRepository.save(supplier);
    }

    public Suppliers updateSupplier(String id, Suppliers supplier) {
        Optional<Suppliers> existingSupplier = suppliersRepository.findById(id);
        if (existingSupplier.isPresent()) {
            Suppliers updatedSupplier = existingSupplier.get();
            updatedSupplier.setName(supplier.getName());
            updatedSupplier.setAddress(supplier.getAddress());
            updatedSupplier.setEmail(supplier.getEmail());
            updatedSupplier.setPhone(supplier.getPhone());
            return suppliersRepository.save(updatedSupplier);
        } else {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
    }

    public void deleteSupplier(String id) {
        Optional<Suppliers> existingSupplier = suppliersRepository.findById(id);
        if (existingSupplier.isPresent()) {
            suppliersRepository.delete(existingSupplier.get());
        } else {
            throw new ResourceNotFoundException("Supplier not found with id: " + id);
        }
    }
}
