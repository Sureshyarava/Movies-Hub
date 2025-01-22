package dev.sureshyarava.movies.services;


import dev.sureshyarava.movies.models.Movie;
import dev.sureshyarava.movies.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbID(String imdbID){
        return movieRepository.findMovieByImdbId(imdbID);
    }
}
