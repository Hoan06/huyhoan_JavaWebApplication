package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction_histories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}