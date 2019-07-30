package com.pivovarit.movies.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieWithDetailsDto {
    private Long id;
    private String title;
    private String details;
    private MovieTypeDto type;
}
