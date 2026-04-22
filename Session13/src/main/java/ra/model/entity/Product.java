package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name",length = 100)
    private String proName;
    @Column(length = 100)
    private String producer;
    @Column(name = "year_marking")
    private Integer yearMarking;
    @Column(name = "expire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
    private double price;
}
