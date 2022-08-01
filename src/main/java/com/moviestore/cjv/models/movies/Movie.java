package com.moviestore.cjv.models.movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;


@Document("movies")
public class Movie {
    @Id
    private String id;

    private String backdrop;
    private List<String> cast;
    private String classification;
    private List<String> director;
    private List<String> genres;
    private Float imdb_rating;
    private String length;
    private String overview;
    private String poster;
    private String released_on;
    private String slug;
    private String type;
    private String title;

    public Movie() {
    }

    public Movie(
            String backdrop,
            List<String> cast,
            String classification,
            List<String> director,
            List<String> genres,
            Float imdb_rating,
            String length,
            String overview,
            String poster,
            String released_on,
            String slug,
            String type,
            String title
    ) {
        this.backdrop = backdrop;
        this.cast = cast;
        this.classification = classification;
        this.director = director;
        this.genres = genres;
        this.imdb_rating = imdb_rating;
        this.length = length;
        this.overview = overview;
        this.poster = poster;
        this.released_on = released_on;
        this.slug = slug;
        this.type = type;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Float getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(Float imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleased_on() {
        return released_on;
    }

    public void setReleased_on(String released_on) {
        this.released_on = released_on;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
