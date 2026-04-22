package ra.model.entiry;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prescriptions")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "prescription",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<PrescriptionDetail> details = new ArrayList<>();

    public void addDetail(PrescriptionDetail detail) {
        details.add(detail);
        detail.setPrescription(this);
    }
}