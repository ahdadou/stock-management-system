package org.sic.Projet_GestionDesStock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

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
    @CreationTimestamp
    private Date createDate;


}
