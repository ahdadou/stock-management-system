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
    private long prixht;
    private int quantity;
    private int totalTTC;
}
