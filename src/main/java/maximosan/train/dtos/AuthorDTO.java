package maximosan.train.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorDTO {
    @JsonProperty(value="url")
    private String url;

    @JsonProperty(value="name")
    private String name;

    public AuthorDTO(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
