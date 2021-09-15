package maximosan.train.models;

import lombok.AllArgsConstructor;
import lombok.Data;


//@Entity
//@Table(name = "Book")
@Data
@AllArgsConstructor
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
}
