package ra.service;

import ra.model.entity.ProjectMember;

import java.util.List;

public interface ProjectService {
    List<ProjectMember> getProjectMembers();
    void addMember(ProjectMember projectMember);
    void deleteMember(Long id);
    ProjectMember getProjectMemberById(Long id);
    void updateProjectMember(ProjectMember projectMember);
    List<ProjectMember> getProjectMembersBySearch(String keyword , String position);
}
