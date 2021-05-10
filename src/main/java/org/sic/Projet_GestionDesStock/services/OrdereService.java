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
	public Ordere saveItem(Ordere category) {
		return ordereRepository.save(category);
	}

//    Get all Items
	public List<Ordere> getAll() {
		return null;
	}

//    Get Item By Id
	public Ordere getById(int id) {
		return null;
	}

//    Delete Item By Id

	public void deeleteById() {

	}

//    Update Item
	public Ordere updateItem() {
		return null;
	}

}
