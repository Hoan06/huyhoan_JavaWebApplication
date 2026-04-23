package ra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vendor {
    @Id
    private Long id;
    private String name;
    private double revenue;
}
