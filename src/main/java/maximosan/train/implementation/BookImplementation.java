package maximosan.train.implementation;

import maximosan.train.models.Book;
import maximosan.train.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImplementation {

    @Autowired
    private BookRepository bookRepository;

    public Book findByName(String name) {
        // if (findByName(name) == null) return exception;
        return bookRepository.findByName(name);
    }
}
