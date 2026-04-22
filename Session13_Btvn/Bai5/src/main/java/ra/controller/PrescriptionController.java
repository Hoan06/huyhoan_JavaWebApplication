package ra.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Prescription;
import ra.repository.PrescriptionRepositoryImpl;

import java.util.List;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
    @Autowired
    private PrescriptionRepositoryImpl prescriptionRepo;

    @GetMapping
    public String list(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Prescription> list;
        if (search != null && !search.isEmpty()) {
            list = prescriptionRepo.searchByPatientCode(search);
        } else {
            list = prescriptionRepo.findAll();
        }
        model.addAttribute("prescriptions", list);
        return "prescription/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "prescription/add";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("prescription") Prescription p, BindingResult result) {
        if (result.hasErrors()) return "prescription/add";
        prescriptionRepo.save(p);
        return "redirect:/prescriptions";
    }
}