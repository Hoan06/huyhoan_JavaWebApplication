package session05.repository;

import org.springframework.stereotype.Repository;
import session05.model.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    public ProjectRepository() {
        projects.add(new Project("P01", "Website bán hàng", "Xây dựng web e-commerce",
                "Nguyễn Văn A", LocalDate.of(2024,1,1),
                LocalDate.of(2024,6,1), 5));

        projects.add(new Project("P02", "App học tiếng Anh", "Mobile app học IELTS",
                "Trần Thị B", LocalDate.of(2024,2,1),
                LocalDate.of(2024,7,1), 7));

        projects.add(new Project("P03", "Hệ thống quản lý nhân sự", "HRM system",
                "Lê Văn C", LocalDate.of(2024,3,1),
                LocalDate.of(2024,8,1), 6));

        projects.add(new Project("P04", "Website du lịch", "Booking tour",
                "Phạm Văn D", LocalDate.of(2024,4,1),
                LocalDate.of(2024,9,1), 4));

        projects.add(new Project("P05", "Chat AI", "Ứng dụng chatbot AI",
                "Hoàng Văn E", LocalDate.of(2024,5,1),
                LocalDate.of(2024,10,1), 8));
    }

    public List<Project> findAll() {
        return projects;
    }

    public Project findById(String id) {
        return projects.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}