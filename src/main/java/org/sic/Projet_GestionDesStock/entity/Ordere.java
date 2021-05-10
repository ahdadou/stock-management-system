package org.sic.Projet_GestionDesStock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordere{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
    private double price;
    private int quantity;
    @CreationTimestamp
    private Date operationDate;


}
