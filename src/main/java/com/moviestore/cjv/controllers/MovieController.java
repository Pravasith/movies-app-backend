package com.moviestore.cjv.controllers;

import com.moviestore.cjv.models.movies.Movie;
import com.moviestore.cjv.services.MovieService;
import com.moviestore.cjv.utils.CustomizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<CustomizedResponse<List<Movie>>> getMovies(){
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: Movies fetched successfully", movies),
                HttpStatus.OK
        );
    }

    @PostMapping(
        value = "/movies",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CustomizedResponse<Movie>> addMovie(@RequestBody() Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: Movie added successfully", movie),
                HttpStatus.CREATED
        );
    }

    @PostMapping(
        value = "/all-movies",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CustomizedResponse<Movie[]>> addMovies(@RequestBody() Movie[] movies) {
        movieService.addMovies(movies);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: Added movies successfully", movies),
                HttpStatus.CREATED
        );
    }
}
