package session06.service;

import org.springframework.stereotype.Service;
import session06.model.Book;
import session06.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAlls() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }
}
