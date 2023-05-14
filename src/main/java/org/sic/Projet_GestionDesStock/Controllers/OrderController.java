package org.sic.Projet_GestionDesStock.Controllers;

import org.sic.Projet_GestionDesStock.dto.EmailRequest;
import org.sic.Projet_GestionDesStock.dto.OrderRequest;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.services.MailService;
import org.sic.Projet_GestionDesStock.services.OrdereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private MailService mailService;

	@Autowired
	private OrdereService ordereService;

	@GetMapping("")
	public ResponseEntity<?> getAllOrder() {
		return new ResponseEntity<>(ordereService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable long id) {
		try {
			ordereService.deleteById(id);
			return new ResponseEntity<>(new Ordere(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE  => " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOrderById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(ordereService.getById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getOrderProductById(@PathVariable long id) {
		System.out.println(id);
		try {
			return new ResponseEntity<>(ordereService.getOrderProducts(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/totalAll")
	public ResponseEntity<?> getTotalPrice() {
		return new ResponseEntity<>(ordereService.getTotal(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addToOrder(@RequestBody OrderRequest orderRequest) {
		try {
			return new ResponseEntity<>(ordereService.addOrder(orderRequest), HttpStatus.OK);
		}catch (Exception exception){

		}

			return new ResponseEntity<>(new Ordere(), HttpStatus.OK);
	}

	@PostMapping("/send")
	public ResponseEntity<?> sendemail(
			@RequestBody EmailRequest emailRequest) throws Exception {

		mailService.sendMail("Contact@gmail.com", emailRequest.getFile(), "facture de vente", "facture de vente",
				emailRequest.getTo(), "merci de votre confiance");
		return new ResponseEntity<>("Teesst", HttpStatus.OK);
	}

	@GetMapping("/TotalPriceByProducts")
	public ResponseEntity<?> TotalPriceByProducts() {
		try {
			return new ResponseEntity<>(ordereService.TotalPriceByProducts(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Cannot retrive data", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/TotalProdouctsOrdered")
	public ResponseEntity<?> TotalProdouctsOrdered() {
		try {
			return new ResponseEntity<>(ordereService.TotalProdouctsOrdered(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Cannot retrive data", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/totalforthismonth")
	public ResponseEntity<?> sumSalesByMonth() {
		 try {
		 	return new ResponseEntity<>(ordereService.getTotalbyMonth(), HttpStatus.OK);
		 } catch (Exception ex) {
			 return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
		 }
	}
}