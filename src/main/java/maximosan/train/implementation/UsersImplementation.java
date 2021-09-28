package maximosan.train.implementation;

import java.util.List;
import maximosan.train.exceptions.BookAlreadyOwnedException;
import maximosan.train.exceptions.BookNotOwnedException;
import maximosan.train.exceptions.UserNotFoundException;
import maximosan.train.exceptions.UserUsernameMismatchException;
import maximosan.train.models.Book;
import maximosan.train.models.Users;
import maximosan.train.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersImplementation {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookImplementation bookImplementation;

    public Iterable findAll() {
        return userRepository.findAll();
    }
    public Users findByName(String name) {
        Users res = userRepository.findByName(name);
        if (res == null)
            throw new UserNotFoundException("user with that name not found.");
        return res;
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(Users user, String username) {
        if (user.getUsername() != username) {
            throw new UserUsernameMismatchException("username doesn't match");
        }
        if (userRepository.findByUsername(username) == null)
            throw new UserNotFoundException("user with that username not found.");
        return userRepository.save(user);
    }
    public void deleteUser(String username) {
        if (userRepository.findByUsername(username) == null)
            throw new UserNotFoundException("user with that username not found.");
        userRepository.deleteByUsername(username);
    }

    public Users findOne(String username) {
        Users res = userRepository.findByUsername(username);
        if (res == null)
            throw new UserNotFoundException("user with that username not found.");
        return res;
    }

    public Users addBook(String username, String isbn) {
        Users user = findOne(username);
        Book book = bookImplementation.findByIsbn(isbn);

        List<String> userBooks = userRepository.getUserBooks(username);
        if (userBooks.contains(isbn)) {
            throw new BookAlreadyOwnedException("user already has book");
        } else {
            user.addBook(book);
            book.setUser_id(username);
            bookImplementation.updateBook(book, book.getIsbn());
        }
        return user;
    }

    public Users removeBook(String username, String isbn) {
        Users user = findOne(username);
        Book book = bookImplementation.findByIsbn(isbn);

        List<String> userBooks = userRepository.getUserBooks(username);
        if (!userBooks.contains(isbn)) {
            throw new BookNotOwnedException("user doesn't have the book");
        }
        user.removeBook(book);
        book.setUser_id(null);
        bookImplementation.updateBook(book, book.getIsbn());
        return user;
    }

}
