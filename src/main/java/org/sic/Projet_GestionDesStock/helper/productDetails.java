package org.sic.Projet_GestionDesStock.helper;

import java.util.Date;

import lombok.Data;

@Data

public class productDetails {
	private String name;
	private double nombreProduct;
	private Date dateoperation;

	public productDetails(String name, long nombreProduct) {
		this.name = name;
		this.nombreProduct = nombreProduct;
	}

	public productDetails() {
	}

	public productDetails(double nombreProduct, Date dateoperation) {
		this.nombreProduct = nombreProduct;
		this.dateoperation = dateoperation;
	}

}
