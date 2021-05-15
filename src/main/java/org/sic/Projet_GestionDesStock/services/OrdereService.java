package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.repository.OrdereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdereService {

	@Autowired private OrdereRepository ordereRepository;

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

//    Delete Item By Id
	public void deleteById(long id) {
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
