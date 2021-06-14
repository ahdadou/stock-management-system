package org.sic.Projet_GestionDesStock.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(length = 50)
	private String city;
	@Column(updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Ordere> ordere;

}
