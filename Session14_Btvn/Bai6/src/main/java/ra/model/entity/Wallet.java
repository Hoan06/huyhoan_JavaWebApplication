package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "wallets")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private Double balance;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TransactionHistory> histories;
}