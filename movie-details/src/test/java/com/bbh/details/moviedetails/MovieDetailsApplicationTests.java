package com.bbh.details.moviedetails;

import com.bbh.details.moviedetails.web.MovieDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieDetailsApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldPing() {
        ResponseEntity<String> responseEntity = testRestTemplate
          .getForEntity(format("http://localhost:%d/ping", port), String.class);
    }

    @Test
    public void detailsEndpointReturnsDetails() {
        ResponseEntity<MovieDetails> responseEntity = testRestTemplate
          .getForEntity(format("http://localhost:%d/api/details/42", port), MovieDetails.class);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getDetails())
          .contains("Details");
    }
}
