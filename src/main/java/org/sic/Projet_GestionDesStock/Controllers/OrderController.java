package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.services.CustomerService;
import org.sic.Projet_GestionDesStock.services.MailService;
import org.sic.Projet_GestionDesStock.services.OrderProductService;
import org.sic.Projet_GestionDesStock.services.OrdereService;
import org.sic.Projet_GestionDesStock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private MailService mailService;

	@Autowired
	private OrdereService ordereService;

	@Autowired
	private CustomerService customerServcie;

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private ProductService productService;

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
			List<OrderProduct> list = ordereService.getOrderProducts(id);
			System.out.println(list.stream().count());
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
			// Create Order
			Customer customer = customerServcie.getById(orderRequest.getIdClient());
			Ordere order = new Ordere();
			order.setCustomer(customer);
			double total = orderRequest.getLignes().stream().mapToDouble(p -> p.getTotalTTC()).sum();
			double totaht = orderRequest.getLignes().stream().mapToDouble(p -> p.getTotalHT()).sum();
			order.setTotal(total);
			order.setTotalht(totaht);
			order = ordereService.saveItem(order);
			System.out.println(orderRequest);
//            Add Product To Order Product
			for (ProductRequest p : orderRequest.getLignes()) {
				OrderProduct orderProduct = new OrderProduct();
				Product poduit = productService.getById(p.getIdProduct());
				orderProduct.setProduct(poduit);
				orderProduct.setOrdere(order);
				orderProduct.setTva(p.getTva());
				orderProduct.setPrix_ht(p.getPrixht());
				orderProduct.setTotalHT(p.getTotalHT());
				orderProduct.setTotalTTC(p.getTotalTTC());
				orderProduct.setQuantity(p.getQuantity());
				orderProductService.saveItem(orderProduct);
			}

			return new ResponseEntity<>(new Ordere(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE CATEGORY", HttpStatus.BAD_REQUEST);
		}
	}

//Send Pdf into Gmail
	@PostMapping("/send")
	public ResponseEntity<?> sendemail(
//            @RequestPart("file") String file
			@RequestBody EmailRequest emailRequest) throws Exception {

		mailService.sendMail("Contact@gmail.com", emailRequest.getFile(), "facture de vente", "facture de vente",
				emailRequest.getTo(), "merci de votre confiance");
		return new ResponseEntity<>("Teesst", HttpStatus.OK);
	}

}