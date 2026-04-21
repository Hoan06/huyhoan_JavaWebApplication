package ra.repository.impl;

import org.springframework.stereotype.Repository;
import ra.model.entity.Course;
import ra.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepositoryImpl() {
        courses.add(new Course(1L , "Lập trình Web" , "Huy Hoàn" , 5 , "dssđsds.png"));
        courses.add(new Course(2L , "Lập trình Mobile" , "Hải Dũng" , 100 , "dssđsds.png"));
        courses.add(new Course(3L , "Python" , "Minh quang" , 20 , "dssđsds.png"));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public void insert(Course course) {
        courses.add(course);
    }

    @Override
    public void update(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                c.setId(course.getId());
                c.setCourseName(course.getCourseName());
                c.setInstructor(course.getInstructor());
                c.setDuration(course.getDuration());
                c.setThumbnail(course.getThumbnail());
            }
        }
    }

    @Override
    public void delete(Long id) {
        courses.removeIf(c -> c.getId().equals(id));
    }
}
