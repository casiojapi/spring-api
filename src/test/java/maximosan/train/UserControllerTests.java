package maximosan.train;

import maximosan.train.controllers.UserController;
import maximosan.train.implementation.UserImplementation;
import maximosan.train.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserImplementation userImplementationTest;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void whenFindAll_thenStatus200()
        throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());

    }
}