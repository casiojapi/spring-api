package maximosan.train.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import maximosan.train.implementation.UserImplementation;
import maximosan.train.models.User;
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
@Api
public class UserController {

    @Autowired
    private UserImplementation userImplementation;

    @GetMapping
    @ApiOperation(value = "return all users", response = Iterable.class)
    public Iterable<User> findAll() {
        return userImplementation.findAll();
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "given a username, return the user", response = User.class)
    public User findOne(@PathVariable String username) {
        return userImplementation.findOne(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "given a user, registers the user", response = User.class)
    public User create(@RequestBody User user) {
        return userImplementation.createUser(user);
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "given a username, deletes the user", response = void.class)
    public void delete(@PathVariable String username) {
        userImplementation.deleteUser(username);
    }

    @PutMapping("/{username}")
    @ApiOperation(value = "given a username and an updated user, updates the old user", response = User.class)
    public User updateUser(@RequestBody User user, @PathVariable String username) {
        return userImplementation.updateUser(user, username);
    }

    @PostMapping("/{username}/{isbn}")
    @ApiOperation(value = "given a username and a isbn book code, adds the book to the user's collection", response = User.class)
    public User addUserBook(@PathVariable String username, @PathVariable
        String isbn) {
        return userImplementation.addBook(username, isbn);
    }


    @DeleteMapping("/{username}/{isbn}")
    @ApiOperation(value = "given a username and a isbn book code, deletes the book from the user's collection", response = User.class)
    public User deleteUserBook(@PathVariable String username, @PathVariable
        String isbn) {
        return userImplementation.removeBook(username, isbn);
    }
}
