package maximosan.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
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


}
