package maximosan.train.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import maximosan.train.dtos.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenLibraryService {

    private static String isbnUrl = "https://openlibrary.org/api/books?bibkeys=ISBN:";
    private static String isbnUrlFormat = "&format=json&jscmd=data"; // 0385472579

    RestTemplate restTemplate = new RestTemplate();

    public BookDTO bookInfo(String isbn) {
        String getUrl = isbnUrl.concat(isbn).concat(isbnUrlFormat);
        Map<String, HashMap<String, Object>> response = restTemplate.getForObject(getUrl, Map.class); // armo un hash

        ObjectMapper objectMapper = new ObjectMapper();
        BookDTO returnBookDTO = new BookDTO();
        try {
            returnBookDTO = objectMapper.readValue(
                objectMapper.writeValueAsString(response.get("ISBN:".concat(isbn))), BookDTO.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return returnBookDTO;
    }

}
