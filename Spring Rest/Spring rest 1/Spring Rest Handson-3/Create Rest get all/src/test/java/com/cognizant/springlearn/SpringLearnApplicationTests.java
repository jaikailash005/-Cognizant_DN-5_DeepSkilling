package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("John")))
                .andExpect(jsonPath("$[0].salary", is(50000.0)))
                .andExpect(jsonPath("$[0].permanent", is(true)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("David")))
                .andExpect(jsonPath("$[1].salary", is(45000.0)))
                .andExpect(jsonPath("$[1].permanent", is(true)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].name", is("Robert")))
                .andExpect(jsonPath("$[2].salary", is(60000.0)))
                .andExpect(jsonPath("$[2].permanent", is(false)))
                .andExpect(jsonPath("$[3].id", is(4)))
                .andExpect(jsonPath("$[3].name", is("Mary")))
                .andExpect(jsonPath("$[3].salary", is(70000.0)))
                .andExpect(jsonPath("$[3].permanent", is(true)));
    }
}
