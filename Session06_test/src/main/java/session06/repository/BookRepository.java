package session06.repository;

import org.springframework.stereotype.Repository;
import session06.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1, "Book 1", "Nguyễn Huy Hoàn", 500000));
        books.add(new Book(2, "Book 2", "An Hải Dũng", 200000));
        books.add(new Book(3, "Book 3", "Hà Minh Trang", 2000));
        books.add(new Book(4, "Book 4", "Phạm Tiến Hưng", 255000));
        books.add(new Book(5, "Book 5", "Đào Trường Sơn", 211100));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
}
