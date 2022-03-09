package com.github.ludmylla.dsmovie.repositories;

import com.github.ludmylla.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
