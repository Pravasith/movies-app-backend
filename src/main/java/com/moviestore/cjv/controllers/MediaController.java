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
import java.util.Optional;

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

    @GetMapping("/media/featured")
    public ResponseEntity<CustomizedResponse<List<Media>>> getFeaturedMovies(@RequestParam("type") String mediaType)
    {
        List<Media> media = mediaService.getFeaturedMediaByType(mediaType);

        return new ResponseEntity<>(
                new CustomizedResponse<>("200: All movies fetched successfully", media),
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

    @GetMapping("/media/{id}")
    ResponseEntity<CustomizedResponse<Optional<Media>>> getMediaById(@PathVariable String id)
    {
        CustomizedResponse<Optional<Media>> customizedResponse = null;

        try
        {
            customizedResponse = new CustomizedResponse<>("200: Fetched Media successfully", mediaService.getMediaById(id));
        }
        catch (Exception e)
        {
            customizedResponse = new CustomizedResponse<>("404: " + e.getMessage(), null);
            return new ResponseEntity<>(
                    customizedResponse,
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                customizedResponse,
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

    @PutMapping(
        value = "/media/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CustomizedResponse<Media>> updateMediaById(
            @PathVariable("id") String id,
            @RequestBody() Media media
    )
    {
        CustomizedResponse<Media> customizedResponse = null;

        try
        {
            customizedResponse = new CustomizedResponse<>("200: Media updated successfully", mediaService.updateMediaById(id, media));
        }
        catch (Exception e)
        {
            customizedResponse = new CustomizedResponse<>("400: " + e.getMessage(), null);
            return new ResponseEntity<>(
                    customizedResponse,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                customizedResponse,
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            value = "/media/{id}"
    )
    public ResponseEntity<CustomizedResponse<Media>> deleteMediaById( @PathVariable("id") String id )
    {
        CustomizedResponse<Media> customizedResponse = null;

        try
        {
            customizedResponse = new CustomizedResponse<>("200: Media deleted successfully", mediaService.deleteMediaById(id));
        }
        catch (Exception e)
        {
            customizedResponse = new CustomizedResponse<>("400: " + e.getMessage(), null);
            return new ResponseEntity<>(
                    customizedResponse,
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                customizedResponse,
                HttpStatus.OK
        );
    }
}
