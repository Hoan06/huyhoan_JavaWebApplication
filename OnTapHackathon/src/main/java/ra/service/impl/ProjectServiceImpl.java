package ra.service.impl;

import org.springframework.stereotype.Service;
import ra.model.entity.ProjectMember;
import ra.repository.ProjectRepository;
import ra.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectMember> getProjectMembers() {
        return projectRepository.findAll();
    }

    @Override
    public void addMember(ProjectMember projectMember) {
        projectRepository.insert(projectMember);
    }

    @Override
    public void deleteMember(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public ProjectMember getProjectMemberById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void updateProjectMember(ProjectMember projectMember) {
        projectRepository.update(projectMember);
    }

    @Override
    public List<ProjectMember> getProjectMembersBySearch(String keyword, String position) {
        return projectRepository.search(keyword, position);
    }


}
