package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.services.CategotyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	private CategotyService categotyService;

	@GetMapping
	public ResponseEntity<List<Category>> categoryList() {
		return new ResponseEntity<>(categotyService.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		try {
			return new ResponseEntity<>(categotyService.saveItem(category), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductByCategory(@PathVariable long id) {
		try {
			return new ResponseEntity<>(categotyService.getProducts(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T GET PRODUCTS => " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable long id, @RequestBody Category category) {
		try {
			Category res = categotyService.getById(id);
			res.setName(category.getName());
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T Update CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCategoty(@PathVariable Long id) {
		try {
			categotyService.deleteById(id);
			return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

}
