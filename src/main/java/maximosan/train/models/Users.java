package maximosan.train.models;

import java.time.LocalDate;
import java.util.List;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import lombok.Data;


@Data
public class Users {

    private String username;
    private String name;
    private LocalDate birthdate;
    private List<Book> books;

    public void addBook(Book book) {
        if (books.contains(book)) {
            throw new BookAlreadyOwnedException("user already owns that book.");
        }
        this.books.add(book);
    }

    //public Users(String username, String name, LocalDate birthdate) {

    //}
}
