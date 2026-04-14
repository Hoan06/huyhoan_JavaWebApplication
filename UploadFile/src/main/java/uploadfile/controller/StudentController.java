package uploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uploadfile.model.dto.StudentDTO;
import uploadfile.model.entity.Student;
import uploadfile.service.UploadImage;


@Controller
@RequestMapping("/students")
public class StudentController {
    private UploadImage uploadImage;
    public StudentController(UploadImage uploadImage) {
        this.uploadImage = uploadImage;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("studentDTO") StudentDTO studentDTO , Model model) {
        Student student = new Student();
        student.setStuId(studentDTO.getStuId());
        student.setFullName(studentDTO.getFullName());
        student.setClassName(studentDTO.getClassName());
        student.setImageUrl(uploadImage.uploadToLocal(studentDTO.getStuImage()));

        model.addAttribute("student", student);
        return "view-student";
    }
}