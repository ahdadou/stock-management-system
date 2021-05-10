package org.sic.Projet_GestionDesStock.services;

import javassist.NotFoundException;
import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategotyService {

    @Autowired
    private CategoryRepository categoryRepository;


//    Add Item
    public Category saveItem(Category category){

        return  categoryRepository.save(category);
}


    //    Get all Items
    public List<Category> getAll(){

        return  categoryRepository.findAll();
    }

//    Get Item By Id
    public Category getById(int id){
        return  categoryRepository.findById((long)id).get();
    }

//    Delete Item By Id

    public void deeleteById(int id){
       categoryRepository.deleteById((long) id);
    }

//    Update Item
    public Category updateItem(Category category){
        return  null;
    }

}
