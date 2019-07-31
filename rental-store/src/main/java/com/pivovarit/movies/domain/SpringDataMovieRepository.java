package com.pivovarit.movies.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataMovieRepository extends JpaRepository<PersistedMovie, Long> {
    Optional<PersistedMovie> findByTitle(String title);
}
