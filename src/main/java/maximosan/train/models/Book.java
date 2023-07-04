package maximosan.train.models;

import java.time.LocalDate;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="Books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String isbn;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "subtitle", nullable = false)
    private String subtitle;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "user_id", nullable = true)
    private String user_id;

    public Book(String isbn, String genre, String author, String image, String subtitle, String publisher, String year, Integer pages) {
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.image = image;
        this.subtitle = subtitle;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.user_id = null;
    }
}
