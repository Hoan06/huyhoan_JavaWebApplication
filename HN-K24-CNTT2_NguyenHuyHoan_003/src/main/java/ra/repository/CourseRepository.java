package ra.repository;

import ra.model.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();
    void insert(Course course);
    void update(Course course);
    void delete(Long id);
}
