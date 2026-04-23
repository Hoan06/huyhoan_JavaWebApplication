package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long stuId;
    @Column(name = "full_name" , length = 50)
    private String fullName;
    private Boolean gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;

    @ManyToOne
    @JoinColumn(name = "class_id" , referencedColumnName = "class_id")
    private Classes classes;
}
