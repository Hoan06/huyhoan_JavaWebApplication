package ra.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import ra.custom_validate.ClassNameValid;
import ra.custom_validate.StuIdValid;

import java.util.Date;

public class Student {
    @NotNull(message = "Chưa nhập mã sinh viên")
    @StuIdValid
    private String stuId;
    @NotBlank(message = "Chưa nhập họ tên")
    private String fullName;
    @NotNull(message = "Chưa nhập giới tính")
    private Boolean gender;
    @NotNull(message = "Chưa nhập ngày sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Ngày sinh không hợp lệ")
    private Date birthday;
    @NotBlank(message = "Chưa nhập địa chỉ")
    private String address;
    @NotBlank(message = "Chưa nhập lớp học")
    @ClassNameValid
    private String className;

    public Student() {
    }

    public Student(String stuId, String fullName, Boolean gender, Date birthday, String address, String className) {
        this.stuId = stuId;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.className = className;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
