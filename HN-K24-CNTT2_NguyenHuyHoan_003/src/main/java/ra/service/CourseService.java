package ra.service;

import org.springframework.stereotype.Service;
import ra.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getALLCourses();
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long id);
    Course findCourseById(Long id);
    List<Course> searchCourse(String keyword);
}
