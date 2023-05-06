package ma.orders.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String description;
    private double totalHT;
    private double totalTTC;
    @CreationTimestamp
    private Date createDate;
    private int quantity;
    private String productId;
    private String supplierId;

}