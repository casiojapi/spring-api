package maximosan.train.controllers;


import maximosan.train.exceptions.UserNotFoundException;
import maximosan.train.exceptions.UserUsernameMismatchException;
import maximosan.train.implementation.UsersImplementation;
import maximosan.train.models.Book;
import maximosan.train.models.Users;
import maximosan.train.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/users")
public class UserController {

    @Autowired
    private UsersImplementation userImplementation;

    @GetMapping
    public Iterable findAll() {
        return userImplementation.findAll();
    }

    @GetMapping("/{username}")
    public Users findOne(@PathVariable String username) {
        return userImplementation.findOne(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users user) {
        return userImplementation.createUser(user);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        userImplementation.deleteUser(username);
    }

    @PutMapping("/{username}")
    public Users updateUser(@RequestBody Users user, @PathVariable String username) {
        return userImplementation.updateUser(user, username);
    }

    @PostMapping("/{username}/{isbn}")
    public Users addUserBook(@PathVariable String username, @PathVariable
        String isbn) {
        return userImplementation.addBook(username, isbn);
    }


    @DeleteMapping("/{username}/{isbn}")
    public Users deleteUserBook(@PathVariable String username, @PathVariable
        String isbn) {
        return userImplementation.removeBook(username, isbn);
    }
}
