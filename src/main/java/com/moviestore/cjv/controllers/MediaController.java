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

    @GetMapping("/media")
    public ResponseEntity<CustomizedResponse<List<Media>>> getAllMedia()
    {
        List<Media> media = mediaService.getAllMedia();
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All media fetched successfully", media),
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
