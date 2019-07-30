package com.bbh.details.moviedetails;

import com.bbh.details.moviedetails.web.MovieDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
