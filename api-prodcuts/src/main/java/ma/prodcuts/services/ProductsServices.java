package ma.prodcuts.services;

import ma.prodcuts.entities.Products;
import ma.prodcuts.exceptions.ResourceNotFoundException;
import ma.prodcuts.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServices {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(String id) {
        return productsRepository.findById(id);
    }

    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    public Products updateProduct(String id, Products product) {
        Optional<Products> existingProduct = productsRepository.findById(id);
        if (existingProduct.isPresent()) {
            Products updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantityStock(product.getQuantityStock());
            updatedProduct.setSupplierId(product.getSupplierId());
            return productsRepository.save(updatedProduct);
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
    }

    public void deleteProduct(String id) {
        Optional<Products> existingProduct = productsRepository.findById(id);
        if (existingProduct.isPresent()) {
            productsRepository.delete(existingProduct.get());
        } else {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
    }
}
