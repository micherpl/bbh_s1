package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
class RestTemplateMovieDetailsRepository implements MovieDetailsRepository {

    private final String url;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public MovieDetails findById(Long id) {
        return restTemplate
          .getForObject(url + "/api/details/" + id, MovieDetails.class);
    }
}
