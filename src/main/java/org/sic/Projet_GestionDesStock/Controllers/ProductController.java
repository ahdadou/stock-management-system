package org.sic.Projet_GestionDesStock.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.entity.SupplierProduct;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.sic.Projet_GestionDesStock.services.SipplierService;
import org.sic.Projet_GestionDesStock.services.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@RestController()
@CrossOrigin("*")
@Log
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private SipplierService supplierService;
	@Autowired
	private SupplierProductService SupplierProductService;
	@Autowired
	ServletContext con;

	// add image of a product
	public String addImage(MultipartFile file) throws IOException {
		boolean isExit = new File(con.getRealPath("/Images/")).exists();
		if (!isExit) {
			new File(con.getRealPath("/Images/")).mkdir();
		}
		// Prepare new file name
		String filename = file.getOriginalFilename();
		Random r = new Random();
		int number = r.nextInt();
		String newFileName = FilenameUtils.getBaseName(filename) + number + System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(filename);

		File serverFile = new File(con.getRealPath("/Images/" + File.separator + newFileName));
		// add file
		FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

		return newFileName;
	}

	// Add Item
	@PostMapping(value = "product/add")
	public ResponseEntity<Object> saveItem(@RequestParam("Product") String product,
			@RequestParam("Supplier") long idSupplier, @RequestParam("ProudctImage") MultipartFile file)
			throws JsonMappingException, JsonProcessingException {
		try {
			String imageName = addImage(file);

			ObjectMapper objectMapper = new ObjectMapper();
			Product p = objectMapper.readValue(product, Product.class);
			p.setImage(imageName);

			Product produit = productService.saveItem(p);
			System.out.print(produit);
			Supplier S = supplierService.getById(idSupplier);
			SupplierProduct SP = new SupplierProduct(produit, S, 0, 0, null);
			SupplierProductService.saveItem(SP);
			return new ResponseEntity<>("PRODUCT ADDED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get all Items
	@GetMapping(value = "/list-product")
	public ResponseEntity<Object> getAll() {
		try {
			return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get Item By Id
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id) {
		try {
			Product product = productService.getById(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/edit/{id}")
	public ResponseEntity<Object> getByIdCategory(@PathVariable Long id) {
		try {
			Product cat = productService.getById(id);
			return new ResponseEntity<>(cat, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	// Delete Item By Id

	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable long id) {
		try {
			productService.deleteById(id);
			return new ResponseEntity<>("PRODUCT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("PRODUCT DELITION FAILED : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Update Item
	@PutMapping(value = "/product/update")
	public ResponseEntity<Object> updateItem(@RequestBody Product product) {
		try {
			productService.saveItem(product);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>("CAN'T UPDATE PRODUCT" + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/product/category/{id}")
	public Category getByIdCategory(@PathVariable long id) {
		return productService.getByIdCategory(id);
	}

	@GetMapping(value = "/product/supplier/{id}")
	public List<Product> ProudctBYSupplierId(@PathVariable long id) {
		return productService.ProudctBYSupplierId(id);
	}
}