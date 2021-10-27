package maximosan.train.utils;

import maximosan.train.dtos.BookDTO;
import maximosan.train.models.Book;

public class BookDTOToBook {
    public Book bookDTOToBook(BookDTO bookDTO) {
        return new Book(bookDTO.getIdentifiers().get("isbn_10").get(0), "empty", bookDTO.getAuthors().get(0).getName(), bookDTO.getCover().get(0), bookDTO.getSubtitle(), bookDTO.getPublishers().get(0).get("name"), bookDTO.getPublishDate(), bookDTO.getNumberOfPages());
    }
}
