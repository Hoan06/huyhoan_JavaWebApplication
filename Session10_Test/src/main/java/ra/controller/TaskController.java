package ra.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.dto.TaskItem;
import ra.model.entity.TaskItemEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

@Controller
@RequestMapping("/job")
public class TaskController {
    List<TaskItem> taskItems;

    public TaskController() {
        taskItems = new ArrayList<>();
        taskItems.add(new TaskItem("I01" , "Công việc 1" , LocalDate.now().plusDays(3), TaskItemEnum.HIGH));
        taskItems.add(new TaskItem("I02" , "Công việc 2" , LocalDate.now().plusDays(4), TaskItemEnum.MEDIUM));
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("taskItem", new  TaskItem());
        return "task-form";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("taskItem") TaskItem taskItem , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "task-form";
        }
        taskItems.add(taskItem);
        model.addAttribute("taskItems", taskItems);
        return "task-list";
    }




}
