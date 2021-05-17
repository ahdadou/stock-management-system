package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.OrderProduct;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.repository.OrderProductRepository;
import org.sic.Projet_GestionDesStock.repository.OrdereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdereService {

	@Autowired private OrdereRepository ordereRepository;
	@Autowired
	private OrderProductRepository orderProductRepository;

	// Add Item
	public Ordere saveItem(Ordere ordere) {
		return ordereRepository.save(ordere);
	}

//    Get all Items
	public List<Ordere> getAll() {
		return ordereRepository.findAll();
	}

//    Get Item By Id
	public Ordere getById(long id) {
		return ordereRepository.findById(id).get();
	}
//	Get Products Order By Id

	public List<OrderProduct> getOrderProducts(long id){
		return orderProductRepository.getByIdOrder(id);
	}

//    Delete Item By Id
	public void deleteById(long id) {
		orderProductRepository.deleteByOrdere_id(id);
		ordereRepository.deleteById(id);
	}

//	Get Total For One Order
//	public double getTotalForOrderById(long id){
//		return ordereRepository.totalPriceforOrder(id);
//	}

//	Fet Total Of all Orders
	public double getTotal(){
		return  ordereRepository.TotalPrice();
	}



//    Update Item
	public Ordere updateItem() {
		return null;
	}

}
