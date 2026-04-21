package ra.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.DoctorDTO;
import ra.model.entity.Doctor;
import ra.service.IDoctorService;
import ra.service.UploadFile;
import ra.service.impl.DoctorServiceImpl;

import java.util.List;

@Controller
@RequestMapping({"/","/doctors"})
public class DoctorController {
    private final IDoctorService doctorService;
    private final UploadFile uploadFile;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public DoctorController(IDoctorService doctorService, UploadFile uploadFile) {
        this.doctorService = doctorService;
        this.uploadFile = uploadFile;
    }

    @ModelAttribute
    public void addConfigToView(Model model) {
        model.addAttribute("appPort", serverPort);
        model.addAttribute("appContextPath", contextPath);
    }

    private Doctor mapToDoctor(DoctorDTO doctorDTO, Doctor doctor) {
        doctor.setFullName(doctorDTO.getFullName());
        doctor.setDepartment(doctorDTO.getDepartment());
        doctor.setExperiYear(doctorDTO.getExperiYear());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setDateWork(doctorDTO.getDateWork());

        if (doctorDTO.getImage() != null && !doctorDTO.getImage().isEmpty()) {
            doctor.setUrlImage(uploadFile.uploadToLocal(doctorDTO.getImage()));
        }

        return doctor;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        model.addAttribute("keyword", "");
        return "list-doctor";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new DoctorDTO());
        model.addAttribute("action", "/doctors/add");
        model.addAttribute("pageTitle", "Thêm bác sĩ");
        return "doctor-form";
    }

    @PostMapping("/add")
    public String addDoctor(@Valid @ModelAttribute("doctor") DoctorDTO doctorDTO,
                            BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/doctors/add");
            model.addAttribute("pageTitle", "Thêm bác sĩ");
            return "doctor-form";
        }

        Doctor doctor = mapToDoctor(doctorDTO, new Doctor());
        doctorService.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        if (doctor == null) {
            return "redirect:/doctors";
        }

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setFullName(doctor.getFullName());
        doctorDTO.setDepartment(doctor.getDepartment());
        doctorDTO.setExperiYear(doctor.getExperiYear());
        doctorDTO.setPhone(doctor.getPhone());
        doctorDTO.setAddress(doctor.getAddress());
        doctorDTO.setDateWork(doctor.getDateWork());

        model.addAttribute("doctor", doctorDTO);
        model.addAttribute("oldImage", doctor.getUrlImage());
        model.addAttribute("action", "/doctors/edit/" + id);
        model.addAttribute("pageTitle", "Cập nhật bác sĩ");
        return "doctor-form";
    }

    @PostMapping("/edit/{id}")
    public String updateDoctor(@PathVariable Long id,
                               @Valid @ModelAttribute("doctor") DoctorDTO doctorDTO,
                               BindingResult result,
                               Model model) {
        Doctor oldDoctor = doctorService.findById(id);
        if (oldDoctor == null) {
            return "redirect:/doctors";
        }

        if (result.hasErrors()) {
            model.addAttribute("oldImage", oldDoctor.getUrlImage());
            model.addAttribute("action", "/doctors/edit/" + id);
            model.addAttribute("pageTitle", "Cập nhật bác sĩ");
            return "doctor-form";
        }

        Doctor updatedDoctor = mapToDoctor(doctorDTO, oldDoctor);
        doctorService.update(updatedDoctor);
        return "redirect:/doctors";
    }

    @GetMapping("/search")
    public String searchDoctor(@RequestParam("phone") String phone, Model model) {
        List<Doctor> doctors = doctorService.findByPhone(phone);
        model.addAttribute("doctors", doctors);
        model.addAttribute("keyword", phone);
        return "list-doctor";
    }

}
