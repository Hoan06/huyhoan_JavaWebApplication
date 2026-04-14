package ra.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ra.custome_validator.MedCode;

public class BookingDto {
    @NotBlank(message = "Họ tên không được để trống hoặc chỉ chứa khoảng trắng")
    private String patientName;

    @Min(value = 0, message = "Tuổi phải từ 0 trở lên")
    private Integer age;

    @NotNull(message = "Mã khoa không được để trống")
    @MedCode
    private String departmentCode;

    public BookingDto() {
    }

    public BookingDto(String patientName, Integer age, String departmentCode) {
        this.patientName = patientName;
        this.age = age;
        this.departmentCode = departmentCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
