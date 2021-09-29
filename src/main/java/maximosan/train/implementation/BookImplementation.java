package maximosan.train.implementation;

import java.util.List;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import maximosan.train.exceptions.BookIsbnMismatchException;
import maximosan.train.exceptions.BookNotFoundException;
import maximosan.train.models.Book;
import maximosan.train.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImplementation {

    @Autowired
    private BookRepository bookRepository;

    public Book findByName(String name) {
        Book res = bookRepository.findByName(name);
        if (res == null)
            throw new BookNotFoundException("book with that name not found.");
        return res;
    }
    public Iterable findAll() {
        return bookRepository.findAll();
    }
    public Book findByIsbn(String isbn) {
        Book res = bookRepository.findByIsbn(isbn);
        if (res == null)
            throw new BookNotFoundException("book with that isbn not found.");
        return res;
    }

    public void deleteByIsbn(String isbn) {
        if (bookRepository.findByIsbn(isbn) == null)
            throw new BookNotFoundException("book with that name not found.");
        bookRepository.deleteByIsbn(isbn);
    }

    public Book updateBook(Book book, String isbn) {
        if (book.getIsbn() != isbn) {
            throw new BookIsbnMismatchException("isbn doesn't match");
        }
        if (bookRepository.findByIsbn(isbn) == null)
            throw new BookNotFoundException("book with that name not found.");
        return bookRepository.save(book);
    }
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List findByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }
}
