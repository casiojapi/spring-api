package maximosan.train.models;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import lombok.Data;
import maximosan.train.exceptions.BookNotFoundException;


@Data
@Entity(name="Users")
public class Users {

    @Id
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @OneToMany(targetEntity=Users.class, mappedBy="books", fetch= FetchType.EAGER)
    @Column(name = "books", nullable = false)
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
