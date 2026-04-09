package session05.service;


import session05.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project getById(String id);
}
