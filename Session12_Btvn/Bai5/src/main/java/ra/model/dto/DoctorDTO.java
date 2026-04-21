package ra.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class DoctorDTO {
    private Long id;
    @NotBlank(message = "Tên không được để trống !")
    private String fullName;
    @NotBlank(message = "Khoa không được để trống !")
    private String department;
    @NotNull(message = "Năm kinh nghiệm không được để trống !")
    private Integer experiYear;
    @NotBlank(message = "Số điện thoại không được để trống !")
    private String phone;
    @NotBlank(message = "Địa chỉ không được để trống !")
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateWork;
    private MultipartFile image;
}
