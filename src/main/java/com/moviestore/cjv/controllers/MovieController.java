package com.moviestore.cjv.controllers;

import com.moviestore.cjv.models.Movie;
import com.moviestore.cjv.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        List<Movie> movies = movieService.getMovies();
        System.out.println(movies.toString());
        return  movies;
    }

    @PostMapping(
            value = "/movies",
            consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public void addMovie(@RequestBody() Movie movie) {
            movieService.addMovie(movie);
    }

    @PostMapping(
            value = "/all-movies",
            consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public void addMovies(@RequestBody() Movie[] movies) {
        movieService.addMovies(movies);
    }
}
