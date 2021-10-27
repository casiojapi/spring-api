package maximosan.train.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class BookDTO implements Serializable {
    @JsonProperty(value = "url")
    private String url;
    @JsonProperty(value = "key")
    private String key;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "subtitle")
    private String subtitle;
    @JsonProperty(value = "authors")
    private List<AuthorDTO> authors;
    @JsonProperty(value = "number_of_pages")
    private Integer numberOfPages;
    @JsonProperty(value = "pagination")
    private String pagination;
    @JsonProperty(value = "identifiers")
    private Map<String,List<String>> identifiers;
    @JsonProperty(value = "classifications")
    private Map<String,List<String>> classifications;
    @JsonProperty(value = "publishers")
    private List<Map<String,String>> publishers;
    @JsonProperty(value = "publish_places")
    private List<Map<String,String>> publishPlaces;
    @JsonProperty(value = "publish_date")
    private String publishDate;
    @JsonProperty(value = "subjects")
    private List<SubjectDTO> subjects;
    @JsonProperty(value = "subject_places")
    private List<SubjectDTO> subjectPlaces;
    @JsonProperty(value = "subject_people")
    private List<SubjectDTO> subjectPeople;
    @JsonProperty(value = "excerpts")
    private List<Map<String,String>> excerpts;
    @JsonProperty(value = "links")
    private List<LinkDTO> links;
    @JsonProperty(value = "ebooks")
    private List<EbookDTO> ebooks;
    @JsonProperty(value = "cover")
    private Map<String,String> cover;
}
