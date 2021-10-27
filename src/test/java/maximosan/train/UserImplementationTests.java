package maximosan.train;

import java.time.LocalDate;
import maximosan.train.exceptions.UserNotFoundException;
import maximosan.train.implementation.UserImplementation;
import maximosan.train.models.User;
import maximosan.train.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplementationTests {

    /*
    @TestConfiguration
    static class UserImplementationTestsContextConfiguration {
        @Bean
        public UserImplementation userImplementationTest() {
            return new UserImplementation();
        }
    }*/

    @Autowired
    private UserImplementation userImplementationTest;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User testUser = new User("roberto_00", "roberto", LocalDate.now());

        Mockito.when(userRepository.findByUsername(testUser.getUsername()))
            .thenReturn(testUser);
    }

    @Test
    public void whenValidUsername_thenUserShouldBeFound() {
        String username = "roberto_00";
        User foundUser = userImplementationTest.findOne(username);

        assertEquals(foundUser.getUsername(), username);
    }

    @Test(expected = UserNotFoundException.class)
    public void whenInvalidUsername_thenUserShouldThrowException() {
        String username = "aaa";
        userImplementationTest.findOne(username);
    }

}
