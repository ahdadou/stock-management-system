package org.sic.Projet_GestionDesStock.Controllers;


import org.hibernate.criterion.Order;
import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.services.CustomerService;
import org.sic.Projet_GestionDesStock.services.OrderProductService;
import org.sic.Projet_GestionDesStock.services.OrdereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrdereService ordereService;

    @Autowired
    private CustomerService customerServcie;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
//    private ProductService productService;

    public OrderController() {
    }


    @GetMapping("")
    public ResponseEntity<?> getAllOrder(){
        return new ResponseEntity<>(ordereService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long id){
        try{
            ordereService.deleteById(id);
            return new ResponseEntity<>("DELETE SUCCESSFULLY",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("CAN'T DELETE CATEGORY",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/totalAll")
    public ResponseEntity<?>  getTotalPrice(){
        return new ResponseEntity<>(ordereService.getTotal(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToOrder(@RequestBody OrderRequest orderRequest){
        try{

            // Create Order
            Customer customer = customerServcie.getById(orderRequest.getIdClient());
            Ordere order = new Ordere();
//            order.setOrderDate(new Date());
            order.setCustomer(customer);
            double total = orderRequest.getLignes().stream().mapToDouble(p -> p.getTotalTTC()).sum();
            order.setTotal(total);
            order = ordereService.saveItem(order);

//            Add Product To Order Product

//            for (ProductRequest p : orderRequest.getLignes()) {
//                OrderProduct orderProduct = new OrderProduct();
////                Product product = productService.getById();
////                orderProduct.setProduct(product);
//                orderProduct.setOrdere(order);
//                orderProduct.setPriceHt(p.getPrixht());
//                orderProduct.setPriceTtc(p.getTotalTTC());
//                orderProduct.setQuantity(p.getQuantity());
//                orderProductService.saveItem(orderProduct);
//
//            }


            return new ResponseEntity<>(new Ordere(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("CAN'T DELETE CATEGORY",HttpStatus.BAD_REQUEST);
        }
    }


}
