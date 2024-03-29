package com.pivovarit.movies.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private MovieTypeDto type;
}
