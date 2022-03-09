package com.github.ludmylla.dsmovie.controller;

import com.github.ludmylla.dsmovie.dto.MovieDTO;
import com.github.ludmylla.dsmovie.dto.ScoreDTO;
import com.github.ludmylla.dsmovie.services.MovieService;
import com.github.ludmylla.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        MovieDTO movieDTO = service.saveScore(dto);
        return movieDTO;
    }
}
