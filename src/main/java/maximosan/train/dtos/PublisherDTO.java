package maximosan.train.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublisherDTO {
    @JsonProperty(value="name")
    private String name;

    public PublisherDTO(String name) {
        this.name = name;
    }
}
