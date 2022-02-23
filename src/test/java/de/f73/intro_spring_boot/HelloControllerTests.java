package de.f73.intro_spring_boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noParams_returnsHelloWorld() throws Exception {
        // GIVEN ARRANGE
        // WHEN ACT
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                // THEN ASSERT
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }
}
