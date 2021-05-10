package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String firstname;
	@Column(length = 25)
	private String lastname;
	@Column(length = 50)
	private String email;
	@Column(length = 25)
	private String phone;
	@Column(length = 50)
	private String address;
	@CreationTimestamp
	private Date createDate;
	@OneToMany(mappedBy = "customer")
	private List<Ordere> ordere;

}
