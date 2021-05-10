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
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_command;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Fournisseur fournisseur;
    private double price;
    private int quantity;
    @CreationTimestamp
    private Date operationDate;

}
