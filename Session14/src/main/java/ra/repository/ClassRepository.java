package ra.repository;

import ra.model.entity.Classes;

import java.util.List;

public interface ClassRepository {
    List<Classes> findAll();
    List<Classes> findAllOnlyClasses();
}
