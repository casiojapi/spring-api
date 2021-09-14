package maximosan.train;

import lombok.Data;

import javax.persistence.*;

//@Entity
//@Table(name = "Book")
@Data
public class Book {
    private String genre;
    private String author;
    private String title;
    private String image;
    private String subtitle;
    private String publisher;
    private String year;
    private Integer pages;
    private String isbn;
    //@Id
    //@GeneratedValue
    //@Column(name = "title", nullable = false);
    public Book(String genre, String author, String title, String image, String subtitle, String publisher, String year, Integer pages, String isbn) {
        this.genre = genre;
        this.author = author;
        this.title = title;
        this.image = image;
        this.subtitle = subtitle;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.isbn = isbn;
    }
}
