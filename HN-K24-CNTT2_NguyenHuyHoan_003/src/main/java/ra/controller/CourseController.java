package ra.controller;

import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.CourseDTO;
import ra.model.entity.Course;
import ra.service.CourseService;
import ra.service.UploadFile;

import java.util.List;

@Controller
@RequestMapping("/")
public class CourseController {
    private CourseService courseService;
    private UploadFile uploadFile;

    public CourseController(CourseService courseService , UploadFile uploadFile) {
        this.courseService = courseService;
        this.uploadFile = uploadFile;
    }

    private Course mapToCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setCourseName(courseDTO.getCourseName());
        course.setInstructor(courseDTO.getInstructor());
        course.setDuration(courseDTO.getDuration());
        course.setThumbnail(uploadFile.uploadToLocal(courseDTO.getImgage()));
        return course;
    }

    @GetMapping({"","home"})
    public String home(Model model) {
        model.addAttribute("courses", courseService.getALLCourses());
        return "home";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new CourseDTO());
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@Valid @ModelAttribute("course") CourseDTO courseDTO , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCourse";
        }
        Course course = mapToCourse(courseDTO);
        courseService.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id , Model model) {
        courseService.deleteCourse(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id , Model model) {
        Course course = courseService.findCourseById(id);
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setInstructor(course.getInstructor());
        courseDTO.setDuration(course.getDuration());
        model.addAttribute("course", courseDTO);
        return "updateCourse";
    }

    @PostMapping("/update")
    public String updateCourse(@Valid @ModelAttribute("course") CourseDTO courseDTO , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "updateCourse";
        }
        Course course = mapToCourse(courseDTO);
        courseService.updateCourse(course);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCourse(@RequestParam("keyword") String keyword ,  Model model) {
        List<Course> courseSearchs = courseService.searchCourse(keyword);
        model.addAttribute("courses", courseSearchs);
        return "home";
    }
}
