package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> fdc94cb9eb82825493c6d669c507a4f5ae5ed369
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
	@Column(length = 25, unique = true)
	private String firstname;
	@Column(length = 25)
	private String lastname;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 25)
	private String phone;
	@Column(length = 50)
	private String address;
	@Column(length = 50)
	private String city;
	@Column(updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Ordere> ordere;

}
