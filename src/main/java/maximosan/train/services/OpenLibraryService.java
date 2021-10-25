package maximosan.train.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import maximosan.train.dtos.BookDTO;
import maximosan.train.models.Book;
import org.springframework.web.client.RestTemplate;

public class OpenLibraryService {

    private static String isbnUrl = "https://openlibrary.org/api/books?bibkeys=ISBN:";
    private static String isbnUrlFormat = "&format=json&jscmd=data"; // 0385472579

    RestTemplate restTemplate = new RestTemplate();

    public Book bookInfo(String isbn) throws Exception {
        String getUrl = isbnUrl.concat(isbn).concat(isbnUrlFormat);
        Map<String, BookDTO> response = restTemplate.getForObject(getUrl, ); // armo un hash

        ObjectMapper objectMapper = new ObjectMapper();
        BookDTO returnBookDTO;
        try {
            returnBookDTO = objectMapper.readValue(
                objectMapper.writeValueAsString(response.get("ISBN:".concat(isbn))), BookDTO.class);
        } catch (JsonProcessingException e) {
            System.out.println("error con bookInfo");

        }

        /*
                try {
            returnBook = objectMapper.readValue(objectMapper.writeValueAsString(mapRequest.get("ISBN:" + isbn)),BookDTO.class);
        }
        catch(JsonProcessingException e){
            System.out.println(e.getMessage());
        }
         */
    }

}
