package com.moviestore.cjv.controllers;

import com.moviestore.cjv.models.media.Media;
import com.moviestore.cjv.services.MediaService;
import com.moviestore.cjv.utils.CustomizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class MediaController
{
    @Autowired
    private MediaService mediaService;

    @GetMapping("/media/movies")
    public ResponseEntity<CustomizedResponse<List<Media>>> getMovies()
    {
        List<Media> media = mediaService.getMediaByType("movie");
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All movies fetched successfully", media),
                HttpStatus.OK
        );
    }

    @GetMapping("/media/tv-shows")
    public ResponseEntity<CustomizedResponse<List<Media>>> getTVShows()
    {
        List<Media> media = mediaService.getMediaByType("tv-series");
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All TV-shows fetched successfully", media),
                HttpStatus.OK
        );
    }

    @GetMapping("/media/movies/featured")
    public ResponseEntity<CustomizedResponse<List<Media>>> getFeaturedMovies()
    {
        List<Media> media = mediaService.getFeaturedMediaByType("movie");
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All movies fetched successfully", media),
                HttpStatus.OK
        );
    }

    @GetMapping("/media/tv-shows/featured")
    public ResponseEntity<CustomizedResponse<List<Media>>> getFeaturedTVShows()
    {
        List<Media> media = mediaService.getFeaturedMediaByType("tv-series");
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All TV-shows fetched successfully", media),
                HttpStatus.OK
        );
    }

    @GetMapping("/media")
    public ResponseEntity<CustomizedResponse<List<Media>>> getMediaHavingName (
            @RequestParam (
                value = "name",
                defaultValue = "empty"
            )
            String name
    )
    {
        if(name.equals("empty")) {
            List<Media> media = mediaService.getAllMedia();
            return new ResponseEntity<>(
                    new CustomizedResponse<>("200: All media fetched successfully", media),
                    HttpStatus.OK
            );
        }

        List<Media> media = mediaService.getMediaHavingName(name);
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: Movies/TV-Shows having name " + name + " fetched successfully", media),
                HttpStatus.OK
        );
    }

    @PostMapping(
        value = "/media",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CustomizedResponse<Media>> addMedia(@RequestBody() Media media)
    {
        mediaService.addMedia(media);
        return new ResponseEntity<> (
                new CustomizedResponse<>("201: Media added successfully", media),
                HttpStatus.CREATED
        );
    }

    @PostMapping(
        value = "/all-media",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CustomizedResponse<Media[]>> addAllMedia(@RequestBody() Media[] media)
    {
        mediaService.addAllMovies(media);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: Added all media successfully", media),
                HttpStatus.CREATED
        );
    }
}
