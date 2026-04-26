package ra.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private Integer totalLimit;
    private Integer usedCount;

    private LocalDateTime expiryDate;
    private String status;

    public boolean hasStock() {
        return usedCount < totalLimit;
    }
}
