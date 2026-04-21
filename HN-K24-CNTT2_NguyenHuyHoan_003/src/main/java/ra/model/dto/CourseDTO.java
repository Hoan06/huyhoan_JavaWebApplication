package ra.model.dto;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import ra.custome_validator.ValidCourseId;

public class CourseDTO {
    @NotNull(message = "Mã khóa học không được để trống !")
//    @ValidCourseId
    private Long id;
    @NotBlank(message = "Tên khóa học không được để trống !")
    @Size(min = 5 , max = 100 , message = "Tên khóa học phải từ 5 đến 100 kí tự !")
    private String courseName;
    @NotBlank(message = "Giảng viên không được để trống !")
    private String instructor;
    @Min(value = 0 , message = "Thời lượng phải lớn hơn 0 !")
    @Max(value = 100 , message = "Thời lượng không được quá 500 giờ !")
    private Integer duration;
    private MultipartFile imgage;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String courseName, String instructor, Integer duration, MultipartFile imgage) {
        this.id = id;
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
        this.imgage = imgage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public MultipartFile getImgage() {
        return imgage;
    }

    public void setImgage(MultipartFile imgage) {
        this.imgage = imgage;
    }
}
