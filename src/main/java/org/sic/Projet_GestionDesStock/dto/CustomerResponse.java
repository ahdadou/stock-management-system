package org.sic.Projet_GestionDesStock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sic.Projet_GestionDesStock.entity.Customer;

@Builder
public class CustomerResponse {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String city;


    public static CustomerResponse toDto(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .city(customer.getCity())
                .build();
    }

}
