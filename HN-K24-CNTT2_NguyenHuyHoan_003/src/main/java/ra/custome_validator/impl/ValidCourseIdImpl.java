package ra.custome_validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ra.custome_validator.ValidCourseId;
import ra.model.entity.Course;
import ra.service.CourseService;

import java.util.List;

public class ValidCourseIdImpl implements ConstraintValidator<ValidCourseId, Long> {
    private CourseService courseService;

    public ValidCourseIdImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        List<Course> courses = courseService.getALLCourses();
        boolean checkId = true;
        for (Course course : courses) {
            if (course.getId().equals(value)) {
                checkId = false;
            }
        }
        if (checkId) {
            return true;
        }
        return false;
    }
}
