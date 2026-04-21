package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity // Tên thực thể trùng với tên class
@Table(name= "employees") // Trong database có bảng : employees
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder // Chuyển class
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;
    @Column(name = "employee_name" , length = 50)
    private String empName;
    private boolean gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String address;
    @Column(length = 100)
    private String company;
    private double salary;
}

// Class này gọi là : Orm ( Object Relation Mapping )
