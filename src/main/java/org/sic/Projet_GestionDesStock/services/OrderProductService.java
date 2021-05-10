package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.sic.Projet_GestionDesStock.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;

//    Add Item
	public OrderProduct saveItem(OrderProduct orderProduct) {

		return orderProductRepository.save(orderProduct);
	}

	// Get all Items
	public List<OrderProduct> getAll() {

		return orderProductRepository.findAll();
	}

//    Get Item By Id
	public OrderProduct getById(long id) {
		return orderProductRepository.findById(id).get();
	}

//    Delete Item By Id

	public void deleteById(int id) {
		orderProductRepository.deleteById((long) id);
	}

//    Update Item
	public OrderProduct updateItem(OrderProduct orderProduct) {
		return orderProductRepository.save(orderProduct);
	}
}
