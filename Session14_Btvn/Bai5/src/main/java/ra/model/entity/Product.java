package ra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private Long id;
    private String name;
    private int stock;
    private double price;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}
