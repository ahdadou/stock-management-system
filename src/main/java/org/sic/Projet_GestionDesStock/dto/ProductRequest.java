package org.sic.Projet_GestionDesStock.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest{
    private long idProduct;
    private double prixht;
    private double totalHT;
    private double reduction;
    private double totalTTC;
    private int quantity;
    private double tva;


}
