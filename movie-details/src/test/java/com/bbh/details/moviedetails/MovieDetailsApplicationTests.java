package com.bbh.details.moviedetails;
import com.bbh.details.moviedetails.web.MovieDetails;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

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

		MovieDetails forObject = testRestTemplate
		.getForObject(format("http://localhost:%d/api/details/42", port), MovieDetails.class);

		MovieDetails forObject2 = testRestTemplate
		.getForObject(format("http://localhost:%d/api/details/42", port), MovieDetails.class);

		System.out.println(forObject.equals(forObject2));
		Assertions.assertThat(forObject).isEqualToComparingFieldByField(forObject2);
		System.out.println(responseEntity.getBody());
	}

}
