package maximosan.train.models;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import lombok.Data;
import maximosan.train.exceptions.BookNotFoundException;


@Data
public class Users {

    private String username;
    private String name;
    private LocalDate birthdate;
    private List<Book> books;

    public Users(String username, String name, LocalDate birthdate) {
        this.username = username;
        this.name = name;
        this.birthdate = birthdate;
        this.books = Collections.emptyList();
    }

    public List<Book> getBooks() {
        return (List<Book>) Collections.unmodifiableList(books);
    }

    public void addBook(Book book) {
        if (books.contains(book)) {
            throw new BookAlreadyOwnedException("user already owns that book.");
        }
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (!books.contains(book)) {
            throw new BookNotFoundException("user does not own that book.");
        }
        this.books.remove(book);
    }
}
