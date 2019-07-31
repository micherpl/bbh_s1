package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("jdbc")
public class JdbcMovieFacadeTest {

    @Autowired
    private MovieFacade movieFacade;

    @Test
    public void smoke_test() throws Exception {
        movieFacade.addMovie(new MovieDto(42L, "spiderman", new MovieTypeDto("NEW")));
        MovieDto movie = movieFacade.getMovie("spiderman").get();
        Assertions.assertThat(movie).isNotNull();
    }
}