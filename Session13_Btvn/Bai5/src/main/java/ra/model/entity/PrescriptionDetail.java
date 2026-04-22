package ra.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "prescription_details")
@Data
public class PrescriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Số lượng thuốc phải lớn hơn hoặc bằng 1")
    private Integer quantity;

    private String medicineName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
