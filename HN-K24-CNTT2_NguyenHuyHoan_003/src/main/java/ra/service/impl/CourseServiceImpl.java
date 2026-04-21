package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Course;
import ra.repository.CourseRepository;
import ra.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getALLCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.update(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public Course findCourseById(Long id) {
        for (Course course : getALLCourses()) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> searchCourse(String keyword) {
        List<Course> coursesSearch = new ArrayList<>();
        for (Course course : getALLCourses()) {
            if (course.getCourseName().toLowerCase().contains(keyword.toLowerCase())
                    ||  course.getInstructor().toLowerCase().contains(keyword.toLowerCase())) {
                coursesSearch.add(course);
            }
        }
        return coursesSearch;
    }
}
