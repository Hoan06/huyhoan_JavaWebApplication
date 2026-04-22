package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Appointment;
import ra.service.AppointmentService;

@Controller
@RequestMapping({"/","/appointment"})
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("appointment", new Appointment());
        return "listAppointments";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/appointment";
    }

    @GetMapping("/call/{id}")
    public String callAppointment(@PathVariable("id") Long id, Model model) {
        appointmentService.updateStatusAppointment(id);
        return "redirect:/appointment";
    }

}
