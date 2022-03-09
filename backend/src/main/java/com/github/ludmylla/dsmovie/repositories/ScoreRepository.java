package com.github.ludmylla.dsmovie.repositories;

import com.github.ludmylla.dsmovie.entities.Score;
import com.github.ludmylla.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
