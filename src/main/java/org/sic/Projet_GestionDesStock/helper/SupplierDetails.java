package org.sic.Projet_GestionDesStock.helper;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDetails {
	private long id;
	private String firstname;
	private String lastname;
	private double price;
	private int quantity;
	private Date operation_date;
	
	public SupplierDetails(String firstname, double price, int quantity, Date operation_date) {
		this.firstname = firstname;
		this.price = price;
		this.quantity = quantity;
		this.operation_date = operation_date;
	}
	
}
