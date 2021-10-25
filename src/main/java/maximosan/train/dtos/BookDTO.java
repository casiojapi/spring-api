package maximosan.train.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BookDTO {
    @JsonProperty(value="ISBN")
    private String isbn;

    @JsonProperty(value="title")
    private String title;

    @JsonProperty(value="subtitle")
    private String subtitle;

    @JsonProperty(value="publishers")
    private List<PublisherDTO> publishers; // mapear todo a @JsonProperty(value="url")

    @JsonProperty(value="publish_date")
    private String publishDate;

    @JsonProperty(value="number_of_pages")
    private int numberOfPages;

    @JsonProperty(value="authors")
    private List<AuthorDTO> authors;

    public BookDTO(String isbn, String title, String subtitle, List<PublisherDTO> publishers, String publishDate, int numberOfPages, List<AuthorDTO> authors) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.publishers = publishers;
        this.publishDate = publishDate;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }
}
