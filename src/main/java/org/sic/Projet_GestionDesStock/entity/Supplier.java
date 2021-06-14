package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25, unique = true)
	private String firstname;
	@Column(length = 25)
	private String lastname;
	@Column(length = 50)
	private String email;
	@Column(length = 25, unique = true)
	private String phone;
	@Column(length = 50)
	private String address;
	@CreationTimestamp
	private Date createDate;
	@OneToMany(mappedBy = "supplier" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<SupplierProduct> supplierProducts;

}
