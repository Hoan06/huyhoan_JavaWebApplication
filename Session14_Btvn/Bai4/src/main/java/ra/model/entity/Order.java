package ra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    private Long id;
    private String status;
    private Long productId;
    private Integer quantity;
    private LocalDateTime expireAt;
}
