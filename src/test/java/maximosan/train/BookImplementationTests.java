package maximosan.train;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import maximosan.train.exceptions.BookNotFoundException;
import maximosan.train.exceptions.UserNotFoundException;
import maximosan.train.implementation.BookImplementation;
import maximosan.train.implementation.UserImplementation;
import maximosan.train.models.Book;
import maximosan.train.models.User;
import maximosan.train.repositories.BookRepository;
import maximosan.train.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookImplementationTests {

    @Autowired
    private BookImplementation bookImplementationTest;

    @MockBean
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        Book testBook = new Book("123aaa", "accion", "aaaa", "aaa", "sa", "444", "333", 32);

        Mockito.when(bookRepository.findByIsbn(testBook.getIsbn()))
            .thenReturn(testBook);
    }

    @Test
    public void whenValidIsbn_thenBookShouldBeFound() {
        String testIsbn = "123aaa";
        Book foundBook = bookImplementationTest.findByIsbn(testIsbn);

        assertEquals(foundBook.getIsbn(), testIsbn);
    }

    @Test(expected = BookNotFoundException.class)
    public void whenInvalidUsername_thenUserShouldThrowException() {
        String invalidIsbn = "aaa";
        bookImplementationTest.findByIsbn(invalidIsbn);
    }

}
