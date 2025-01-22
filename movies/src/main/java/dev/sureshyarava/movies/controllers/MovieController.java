package dev.sureshyarava.movies.controllers;


import dev.sureshyarava.movies.models.Movie;
import dev.sureshyarava.movies.repositories.MovieRepository;
import dev.sureshyarava.movies.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
@Slf4j
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService, MovieRepository movieRepository){
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.getMovieByImdbID(imdbId), HttpStatus.OK);
    }


}
