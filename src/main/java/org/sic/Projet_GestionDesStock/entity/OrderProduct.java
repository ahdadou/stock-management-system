package org.sic.Projet_GestionDesStock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Ordere ordere;
    @ManyToOne
    private Product product;
    private double price;
    private double totalHT;
    private double totalTTC;
    private int quantity;



=======
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Ordere ordere;
	@ManyToOne
	private Product product;
	private double price;
	private int quantity;
>>>>>>> fdc94cb9eb82825493c6d669c507a4f5ae5ed369

}
