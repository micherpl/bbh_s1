package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class MoviePriceCalculator {

    private final int oldPrice;
    private final int newPrice;
    private final int regularPrice;

    int calculatePrice(Movie movie) {
        switch (movie.getType()) {
            case NEW: return newPrice;
            case REGULAR: return regularPrice;
            case OLD: return oldPrice;
            default: throw new IllegalStateException("illegal movie type encountered");
        }
    }
}
