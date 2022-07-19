package com.moviestore.cjv.services;

import com.moviestore.cjv.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    public List<Movie> getMovies(){
        return List.of(new Movie(1L, "Avatar", "Fantasy, Action"));
    }
}
