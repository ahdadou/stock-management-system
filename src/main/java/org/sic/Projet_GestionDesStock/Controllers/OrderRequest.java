package org.sic.Projet_GestionDesStock.Controllers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class OrderRequest {

    private long idClient;
    private List<ProductRequest> lignes;

}

@Data @NoArgsConstructor
class ProductRequest{
    private long idProduct;
    private double prixht;
    private double totalHT;
    private double reduction;
    private double totalTTC;
    private int quantity;
    private double tva;


}
