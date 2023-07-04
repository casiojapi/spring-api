package maximosan.train;

import maximosan.train.controllers.BookController;
import maximosan.train.implementation.BookImplementation;
import maximosan.train.repositories.BookRepository;
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
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookImplementation bookImplementationTest;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void whenFindAll_thenStatus200()
        throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()); /*
            .andExpect(MockMvcResultMatchers.content().string("{\n" +
                "    \"error_code\": invalid_schema,\n" +
                "    \"message\": Invalid schema\n" +
                "}")); */
        // testear con json bien armado
    }

}