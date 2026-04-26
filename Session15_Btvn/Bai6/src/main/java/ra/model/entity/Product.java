package ra.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private Integer stockQuantity;
    private String category;
    private Boolean status;
}
