package ra.service;

import ra.model.entity.Classes;

import java.util.List;

public interface ClassService {
    List<Classes> getAllClasses();
    List<Classes> getAllOnlyClasses();
}
