package ra.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.dto.TodoDTO;
import ra.model.entity.Todo;
import ra.repository.TodoRepository;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String todos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("todo", new TodoDTO());
        return "addTodo";
    }

    @PostMapping("/add")
    public String addTodo(@Valid @ModelAttribute("todo") TodoDTO todoDTO , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        Todo todo = new Todo();
        todo.setContent(todoDTO.getContent());
        todo.setDueDate(todoDTO.getDueDate());
        todo.setStatus(todoDTO.isStatus());
        todo.setPriority(todoDTO.getPriority());
        todoRepository.save(todo);
        return "redirect:/todos";
    }
}
