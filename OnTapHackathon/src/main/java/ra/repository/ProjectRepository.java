package ra.repository;

import org.springframework.stereotype.Repository;
import ra.model.dto.ProjectMemberDTO;
import ra.model.entity.ProjectMember;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository {
    List<ProjectMember> projectMembers = new ArrayList<>();

    public ProjectRepository() {
        projectMembers.add(new ProjectMember(1L, "Nguyễn Văn A", "Backend Developer", 3.5, "avatar1.png", "vana@gmail.com"));
        projectMembers.add(new ProjectMember(2L, "Trần Thị B", "Frontend Developer", 2.0, "avatar2.png", "thib@gmail.com"));
        projectMembers.add(new ProjectMember(3L, "Lê Văn C", "Project Manager", 5.0, "avatar3.png", "vanc@gmail.com"));
        projectMembers.add(new ProjectMember(4L, "Phạm Thị D", "QA Engineer", 1.5, "avatar4.png", "thid@gmail.com"));
        projectMembers.add(new ProjectMember(5L, "Hoàng Văn E", "DevOps Engineer", 4.0, "avatar5.png", "vane@gmail.com"));
    }

    public List<ProjectMember> findAll() {
        return projectMembers;
    }

    public ProjectMember findById(Long id) {
        return projectMembers.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void insert(ProjectMember projectMember) {
        projectMembers.add(projectMember);
    }

    public void update(ProjectMember projectMember) {
        for (ProjectMember p : projectMembers) {
            if (p.getId().equals(projectMember.getId())) {
                p.setFullName(projectMember.getFullName());
                p.setPosition(projectMember.getPosition());
                p.setExperienceYears(projectMember.getExperienceYears());
                p.setAvatar(projectMember.getAvatar());
                p.setEmail(projectMember.getEmail());
                break;
            }
        }
    }

    public void delete(Long id) {
        projectMembers.removeIf(p -> p.getId().equals(id));
    }

    public List<ProjectMember> search(String keyword , String position) {
        return projectMembers.stream().filter(p -> keyword == null || keyword.isEmpty()
        || p.getFullName().toLowerCase().contains(keyword.toLowerCase()))
                .filter(p -> position == null || position.isEmpty()
                        || p.getPosition().equals(position)).toList();
    }
}
