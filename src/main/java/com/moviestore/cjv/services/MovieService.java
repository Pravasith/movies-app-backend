package com.moviestore.cjv.services;

import com.moviestore.cjv.models.Movie;
import com.moviestore.cjv.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.insert(movie);
    }

    public void addMovies(Movie[] movies) {
        movieRepository.saveAll(Arrays.stream(movies).toList());
    }
}
