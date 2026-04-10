package session06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import session06.model.Book;
import session06.service.BookService;

@Controller
@RequestMapping(value = {"/" , "/book"})
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String book(Model model) {
        model.addAttribute("books", bookService.getAlls());
        return "book";
    }

    @GetMapping("/bookDetail/{id}")
    public String bookDetail(@PathVariable("id") String id, Model model) {
        if (id == null) {
            model.addAttribute("book", bookService.getAlls());
            return "redirect:/book";
        }
        model.addAttribute("book" , bookService.findById(Integer.parseInt(id)));
        return "bookDetail";
    }
}
