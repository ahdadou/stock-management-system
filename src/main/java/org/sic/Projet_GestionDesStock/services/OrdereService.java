package org.sic.Projet_GestionDesStock.services;

import org.sic.Projet_GestionDesStock.dto.OrderRequest;
import org.sic.Projet_GestionDesStock.dto.ProductRequest;
import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.helper.productDetails;
import org.sic.Projet_GestionDesStock.repository.OrderProductRepository;
import org.sic.Projet_GestionDesStock.repository.OrdereRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdereService {
	Logger logger = LoggerFactory.getLogger(OrdereService.class);

	@Autowired
	private OrdereRepository ordereRepository;
	@Autowired
	private OrderProductRepository orderProductRepository;
	@Autowired
	private CustomerService customerServcie;
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrdereService ordereService;
	public Ordere saveItem(Ordere ordere) {
		logger.info("Saving order");
		return ordereRepository.save(ordere);
	}

	public List<Ordere> getAll() {
		logger.info("Getting all orders");
		return ordereRepository.findAll();
	}

	public Ordere getById(long id) {
		logger.info("Getting order by id");
		return ordereRepository.findById(id).get();
	}

	public List<OrderProduct> getOrderProducts(long id) {
		return orderProductRepository.getByIdOrder(id);
	}

	public void deleteById(long id) {
		logger.info("Deleting order by id");
		orderProductRepository.deleteByOrdere_id(id);
		ordereRepository.deleteById(id);
	}


	public double getTotal() {
		return ordereRepository.TotalPrice();
	}

	public List<productDetails> TotalPriceByProducts() {
		return this.ordereRepository.TotalPriceByProducts();
	}

	public List<productDetails> TotalProdouctsOrdered() {

		return this.ordereRepository.TotalProdouctsOrdered();
	}

	public Ordere updateItem() {
		return null;
	}


	public double getTotalbyMonth(){
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return this.ordereRepository.totalByMonth(month);
	}


	public Object addOrder(OrderRequest orderRequest) {
		logger.info("Adding order");
		Ordere order = new Ordere();
		order.setCustomer(customerServcie.getById(orderRequest.getIdClient()));
		double total = orderRequest.getLignes().stream().mapToDouble(p -> p.getTotalTTC()).sum();
		double totaht = orderRequest.getLignes().stream().mapToDouble(p -> p.getTotalHT()).sum();
		order.setTotal(total);
		order.setTotalht(totaht);
		order = ordereService.saveItem(order);
		for (ProductRequest p : orderRequest.getLignes()) {
			Product poduit = productService.getById(p.getIdProduct());
			poduit.setQuantityStock(poduit.getQuantityStock() - p.getQuantity());
			productService.updateItem(poduit);
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(poduit);
			orderProduct.setOrdere(order);
			orderProduct.setTva(p.getTva());
			orderProduct.setPrix_ht(p.getPrixht());
			orderProduct.setTotalHT(p.getTotalHT());
			orderProduct.setTotalTTC(p.getTotalTTC());
			orderProduct.setQuantity(p.getQuantity());
			orderProductService.saveItem(orderProduct);
		}
		return order;
	}
}
