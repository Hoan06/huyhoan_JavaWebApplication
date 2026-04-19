package ra.model.dto;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import ra.custome_validator.ValidEmail;

public class ProjectMemberDTO {
    @NotNull(message = "Id không được để trống !")
    private Long id;
    @NotBlank(message = "Tên nhân sự không được để trống !")
    @Size(min = 5 , max = 50 , message = "Tên phải từ 5 đến 50 kí tự !")
    private String fullName;
    @NotBlank(message = "Vị trí không được để trống !")
    private String position;
    @Min(value = 0 , message = "Kinh nghiệm phải lớn hơn 0")
    private Double experienceYears;
    private MultipartFile imageAvatar;
    @NotBlank(message = "Email không được để trống !")
    @ValidEmail
    private String email;

    public ProjectMemberDTO() {
    }

    public ProjectMemberDTO(Long id, String fullName, String position, Double experienceYears, MultipartFile imageAvatar, String email) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.experienceYears = experienceYears;
        this.imageAvatar = imageAvatar;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Double experienceYears) {
        this.experienceYears = experienceYears;
    }

    public MultipartFile getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(MultipartFile imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

