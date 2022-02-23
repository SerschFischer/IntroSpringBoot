package de.f73.intro_spring_boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noParams_returnsHelloWorld() throws Exception {
        // GIVEN ARRANGE
        // WHEN ACT
        mockMvc.perform(get("/hello"))
                // THEN ASSERT
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void sayHello_myName_returnsHelloName() throws Exception {
        // GIVEN
        // WHEN
        mockMvc.perform(get("/hello?name=Sersch"))
        // THEN
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Sersch"));
    }
}
