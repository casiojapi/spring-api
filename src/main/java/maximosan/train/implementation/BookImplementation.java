package maximosan.train.implementation;

import java.util.List;
import maximosan.train.dtos.BookDTO;
import maximosan.train.dtos.BookHttpStatusDTO;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import maximosan.train.exceptions.BookIsbnMismatchException;
import maximosan.train.exceptions.BookNotFoundException;
import maximosan.train.models.Book;
import maximosan.train.repositories.BookRepository;
import maximosan.train.services.OpenLibraryService;
import maximosan.train.utils.BookDTOToBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImplementation {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OpenLibraryService openLib;

    @Autowired
    private BookDTOToBook bookDTOToBook;

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
        if (res == null) {
            BookDTO bookDTO = openLib.bookInfo(isbn);
            if (bookDTO == null)
                return null;        // aca, si el libro no esta, deberia saltar la excepcion en book info. Por ende, hace falta validar esto?
                                    // en caso de que haya que validar, devuelvo null o una excepcion?
            res = bookDTOToBook.bookDTOToBook(bookDTO);
            bookRepository.save(res);
        }
        return res;
    }

    public Book findByIsbnOpenLib(String isbn) {
        BookDTO bookDTO = openLib.bookInfo(isbn);
        if (bookDTO == null)
            return null;        // aca, si el libro no esta, deberia saltar la excepcion en book info. Por ende, hace falta validar esto?
                                // en caso de que haya que validar, devuelvo null o una excepcion?
        Book res = bookDTOToBook.bookDTOToBook(bookDTO);
        return bookRepository.save(res);
    }

    public BookHttpStatusDTO findByIsbnStatusCode(String isbn) {
        Book foundBook = findByIsbn(isbn);
        if (foundBook == null) {
            foundBook = findByIsbnOpenLib(isbn);
            if (foundBook == null) {
                return new BookHttpStatusDTO(null, "404");
            }
            return new BookHttpStatusDTO(foundBook, "201");
        }
        return new BookHttpStatusDTO(foundBook, "200");
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
