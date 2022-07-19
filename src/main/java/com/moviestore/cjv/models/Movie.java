package com.moviestore.cjv.models;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


//@Document("movies")
public class Movie {
//    @Id
    private Long id;
    private String name;
    private String genre;

    public Movie() {
    }

    public Movie(Long id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
