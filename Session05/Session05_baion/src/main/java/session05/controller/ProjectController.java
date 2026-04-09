package session05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import session05.model.Project;
import session05.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", service.getAll());
        return "project/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        Project project = service.getById(id);
        if (project == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy dự án với mã: " + id);
            return "redirect:/projects";
        }
        model.addAttribute("project", project);
        return "project/detail";
    }
}
