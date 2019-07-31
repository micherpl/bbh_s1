package com.pivovarit.movies.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("jpa")
public interface SpringDataMovieRepository extends JpaRepository<PersistedMovie, Long> {
    Optional<PersistedMovie> findByTitle(String title);
}
