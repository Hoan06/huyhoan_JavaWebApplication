package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long proId;
    @Column(name = "product_name" , length = 100 , nullable = false)
    private String proName;
    @Column(name = "producer" , length = 100 , nullable = false)
    private String producer;
    @Column(name = "year_marking" , nullable = false)
    private Integer yearMarking;
    @Column(name = "price" , nullable = false)
    private Double price;
}
