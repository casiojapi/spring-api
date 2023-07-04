package maximosan.train.dtos;

import lombok.Data;
import maximosan.train.models.Book;

@Data
public class BookHttpStatusDTO {
    private Book book;
    private String httpStatus;

    public BookHttpStatusDTO(Book book, String status) {
        this.book = book;
        this.httpStatus = status;
    }
}
