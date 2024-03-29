package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.entity.Employee;
import org.sic.Projet_GestionDesStock.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EmployeeConttroller {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/Employees/list")
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/Employee/add")
	public ResponseEntity<?> saveItem(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(employeeService.saveItem(employee), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD Employee", HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/Employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/Employee/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(employeeService.updateItem(employee), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T Update Employee", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/Employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		try {
			employeeService.deeleteById(id);
			return new ResponseEntity<>("Employee DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE Employee", HttpStatus.BAD_REQUEST);
		}
	}

}
