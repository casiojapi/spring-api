package maximosan.train.controllers;

import io.swagger.annotations.Api;
import java.util.List;
import maximosan.train.exceptions.BookIsbnMismatchException;
import maximosan.train.exceptions.BookNotFoundException;
import maximosan.train.implementation.BookImplementation;
import maximosan.train.models.Book;
import maximosan.train.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/books")
@Api
public class BookController {

    @Autowired
    private BookImplementation bookImplementation;

    @GetMapping
    public Iterable findAll() {
        return bookImplementation.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookImplementation.findByTitle(bookTitle);
    }

    @GetMapping("/{isbn}")
    public Book findOne(@PathVariable String isbn) {
        return bookImplementation.findByIsbn(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookImplementation.createBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable String isbn) {
        bookImplementation.deleteByIsbn(isbn);
    }

    @PutMapping("/{isbn}")
    public Book updateBook(@RequestBody Book book, @PathVariable String isbn) {
        return bookImplementation.updateBook(book, isbn);
    }

}
