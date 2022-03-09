package com.github.ludmylla.dsmovie.services;


import com.github.ludmylla.dsmovie.dto.MovieDTO;
import com.github.ludmylla.dsmovie.dto.ScoreDTO;
import com.github.ludmylla.dsmovie.entities.Movie;
import com.github.ludmylla.dsmovie.entities.Score;
import com.github.ludmylla.dsmovie.entities.User;
import com.github.ludmylla.dsmovie.repositories.MovieRepository;
import com.github.ludmylla.dsmovie.repositories.ScoreRepository;
import com.github.ludmylla.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore (ScoreDTO dto){

        User user = userEmailIfSearchDoesNotExistSaved(dto);

        Movie movie = findMovieById(dto);

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        scoreRepository.saveAndFlush(score);

        calculateMovieScoreAndSaveMovie(movie);

        return new MovieDTO(movie);

    }

    private User findByEmail(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        return user;
    }

    private User userEmailIfSearchDoesNotExistSaved(ScoreDTO dto) {
        User user = findByEmail(dto);
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        return user;
    }

    private Movie findMovieById(ScoreDTO dto) {
        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        return movie;
    }

    public void calculateMovieScoreAndSaveMovie (Movie movie){
        double sum = 0.0;
        for(Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movieRepository.saveAndFlush(movie);
    }



}
