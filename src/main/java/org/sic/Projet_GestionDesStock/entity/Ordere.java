package org.sic.Projet_GestionDesStock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordere{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "ordere", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;
    @CreationTimestamp
    private Date orderDate;
    private double total;
    private double totalht;


}
