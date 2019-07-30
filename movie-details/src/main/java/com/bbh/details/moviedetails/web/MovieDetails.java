package com.bbh.details.moviedetails.web;

public class MovieDetails {
    private String details;

    public MovieDetails() {
    }

    MovieDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
          "details='" + details + '\'' +
          '}';
    }
}