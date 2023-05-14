package org.sic.Projet_GestionDesStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmailRequest {

    private String file;
    private String to;
}
