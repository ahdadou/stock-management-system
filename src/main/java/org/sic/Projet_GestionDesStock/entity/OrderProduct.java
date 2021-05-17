package org.sic.Projet_GestionDesStock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JsonIgnore
    private Ordere ordere;
    @ManyToOne
    private Product product;
    private double prix_ht;
    private double totalHT;
    private double totalTTC;
    private int quantity;
    private double tva;





}
