package maximosan.train.controllers;

import io.swagger.annotations.Api;
import java.util.List;
import maximosan.train.dtos.BookHttpStatusDTO;
import maximosan.train.implementation.BookImplementation;
import maximosan.train.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/external/{bookIsbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String bookIsbn){
        BookHttpStatusDTO bookStatusResponse =  bookImplementation.findByIsbnStatusCode(bookIsbn);
        switch (bookStatusResponse.getHttpStatus()){
            case "200":
                return new ResponseEntity<>(bookStatusResponse.getBook(), HttpStatus.OK);
            case "201":
                return new ResponseEntity<>(bookStatusResponse.getBook(), HttpStatus.CREATED);
            default:
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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
