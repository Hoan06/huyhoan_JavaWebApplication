package ra.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.ProjectMemberDTO;
import ra.model.entity.ProjectMember;
import ra.service.impl.ProjectServiceImpl;
import ra.service.impl.UploadImageImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/"})
public class ProjectController {
    private ProjectServiceImpl projectService;
    private UploadImageImpl uploadImage;

    public ProjectController(ProjectServiceImpl projectService , UploadImageImpl uploadImage) {
        this.projectService = projectService;
        this.uploadImage = uploadImage;
    }

    private ProjectMember mapToProjectMember(ProjectMemberDTO projectMemberDTO) {
        ProjectMember projectMember = new ProjectMember();
        projectMember.setId(projectMemberDTO.getId());
        projectMember.setFullName(projectMemberDTO.getFullName());
        projectMember.setPosition(projectMemberDTO.getPosition());
        projectMember.setExperienceYears(projectMemberDTO.getExperienceYears());
        projectMember.setAvatar(uploadImage.uploadToLocal(projectMemberDTO.getImageAvatar()));
        projectMember.setEmail(projectMemberDTO.getEmail());
        return projectMember;
    }

    @GetMapping({"","/home"})
    public String home(Model model) {
        model.addAttribute("projects" , projectService.getProjectMembers());
        model.addAttribute("positions" , getAllPositions(projectService.getProjectMembers()));
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("member" , new ProjectMemberDTO());
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("member") ProjectMemberDTO memberDTO , BindingResult result, Model model) {
        if  (result.hasErrors()) {
            return "add-member";
        }
        ProjectMember projectMember = mapToProjectMember(memberDTO);
        projectService.addMember(projectMember);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        projectService.deleteMember(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        ProjectMember projectMember = projectService.getProjectMemberById(id);
        ProjectMemberDTO projectMemberDTO = new ProjectMemberDTO();
        projectMemberDTO.setId(projectMember.getId());
        projectMemberDTO.setFullName(projectMember.getFullName());
        projectMemberDTO.setPosition(projectMember.getPosition());
        projectMemberDTO.setExperienceYears(projectMember.getExperienceYears());
        projectMemberDTO.setEmail(projectMember.getEmail());

        model.addAttribute("member" , projectMemberDTO);
        return "update-member";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("member") ProjectMemberDTO memberDTO , BindingResult result , Model model ){
         if  (result.hasErrors()) {
             return "update-member";
         }
         ProjectMember projectMember = mapToProjectMember(memberDTO);
         projectService.updateProjectMember(projectMember);
         return "redirect:/home";
    }

    private List<String> getAllPositions(List<ProjectMember> projectMember){
        List<String> positions = new ArrayList<>();
        for (ProjectMember p : projectMember){
            positions.add(p.getPosition());
        }
        return positions;
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword" , required = false) String keyword ,
            @RequestParam(value = "position" , required = false) String position, Model model) {
        List<ProjectMember> projectMembers = projectService.getProjectMembersBySearch(keyword, position);
        model.addAttribute("projects" , projectMembers);
        model.addAttribute("positions" , getAllPositions(projectService.getProjectMembers()));
        return "home";
    }
}
