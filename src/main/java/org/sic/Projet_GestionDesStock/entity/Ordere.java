package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
public class Ordere{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "ordere")
    private List<OrderProduct> orderProducts;
    @CreationTimestamp
    private Date orderDate;
    private double total;
=======
public class Ordere {
>>>>>>> fdc94cb9eb82825493c6d669c507a4f5ae5ed369

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy = "ordere")
	private List<OrderProduct> orderProducts;
	@CreationTimestamp
	private Date orderDate;

}
