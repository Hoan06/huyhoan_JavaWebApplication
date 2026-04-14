package uploadfile.model.entity;

public class Student {
    private String stuId;
    private String fullName;
    private String className;
    private String imageUrl;

    public Student() {
    }

    public Student(String stuId, String fullName, String className, String imageUrl) {
        this.stuId = stuId;
        this.fullName = fullName;
        this.className = className;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
