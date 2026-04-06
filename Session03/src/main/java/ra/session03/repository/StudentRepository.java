package ra.session03.repository;

import org.springframework.stereotype.Repository;
import ra.session03.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students  = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1, "Nguyễn Văn Anh", "Khoa Công nghệ thông tin", 2022, 3.85, "Đang học"));
        students.add(new Student(2, "Trần Thị Bảo", "Khoa Kinh tế đầu tư", 2023, 3.10, "Đang học"));
        students.add(new Student(3, "Lê Hoàng Chinh", "Khoa Điện tử viễn thông", 2021, 1.95, "Cảnh cáo"));
        students.add(new Student(4, "Phạm Minh Đức", "Khoa Quản trị kinh doanh", 2020, 3.55, "Đã tốt nghiệp"));
        students.add(new Student(5, "Hoàng Thu Giang", "Khoa Ngôn ngữ Anh", 2024, 0.0, "Mới nhập học"));
    }


    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return findAll().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
}
