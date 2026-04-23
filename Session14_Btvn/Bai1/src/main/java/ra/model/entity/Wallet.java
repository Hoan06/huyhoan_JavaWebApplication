package ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "wallets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "user_id")
    private Long userId;

}