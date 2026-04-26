package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<VoucherUsage> usedVouchers;

    public User(Long id) {
        this.id = id;
    }
}