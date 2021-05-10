package org.sic.Projet_GestionDesStock.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@Column(updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@OneToMany(mappedBy = "customer")
	private List<Ordere> ordere;

}
