package com.cognizant.springlearn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testUpdateEmployeeException()
            throws Exception {

        String employee = """
        {
            "id":"abc",
            "name":"John",
            "salary":50000,
            "permanent":true
        }
        """;

        mvc.perform(

                put("/employees")

                .contentType(MediaType.APPLICATION_JSON)

                .content(employee))

                .andExpect(status().isBadRequest());

    }

    @Test
    public void testDeleteEmployee() throws Exception {
        mvc.perform(delete("/employees/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteEmployeeNotFound() throws Exception {
        mvc.perform(delete("/employees/100"))
                .andExpect(status().isNotFound());
    }

}
