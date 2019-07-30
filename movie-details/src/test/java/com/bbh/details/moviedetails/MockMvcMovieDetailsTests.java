package com.bbh.details.moviedetails;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockMvcMovieDetailsTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldPing() throws Exception {
        mockMvc
          .perform(get("/ping"))
          .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void detailsEndpointReturnsDetails() throws Exception {
        // MockMvcRequestBuilders
        // MockMvcResultMatchers
        // org.hamcrest.Matchers

        mockMvc
          .perform(get("/api/details/42"))
          .andExpect(status().is2xxSuccessful())
          .andExpect(jsonPath("$.details", containsString("Details")));
    }
}
