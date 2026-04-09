package session05.service.impl;

import org.springframework.stereotype.Service;
import session05.model.Project;
import session05.repository.ProjectRepository;
import session05.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAll() {
        return repository.findAll();
    }

    @Override
    public Project getById(String id) {
        return repository.findById(id);
    }
}