package org.sic.Projet_GestionDesStock.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class OrderRequest {

    private long idClient;
    private List<ProductRequest> lignes;

}


