package uploadfile.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class StudentDTO {
    private String stuId;
    private String fullName;
    private String className;
    private MultipartFile stuImage;

    public StudentDTO() {
    }

    public StudentDTO(String stuId, String fullName, String className, MultipartFile stuImage) {
        this.stuId = stuId;
        this.fullName = fullName;
        this.className = className;
        this.stuImage = stuImage;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MultipartFile getStuImage() {
        return stuImage;
    }

    public void setStuImage(MultipartFile stuImage) {
        this.stuImage = stuImage;
    }
}
