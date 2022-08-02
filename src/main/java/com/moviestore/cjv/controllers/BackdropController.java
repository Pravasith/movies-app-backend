package com.moviestore.cjv.controllers;

import com.moviestore.cjv.models.backdrops.Backdrop;
import com.moviestore.cjv.services.BackdropService;
import com.moviestore.cjv.utils.CustomizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class BackdropController {
    @Autowired
    private BackdropService backdropService;

    @GetMapping("/backdrops")
    public ResponseEntity<CustomizedResponse<List<Backdrop>>> getBackdrops() {
        return new ResponseEntity<>(
                new CustomizedResponse<>("200: Fetched backdrops successfully", backdropService.getBackdrops()),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "/backdrops", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CustomizedResponse<Backdrop>> addBackdrop(@RequestBody Backdrop backdrop) {
        backdropService.addBackdrop(backdrop);

        return new ResponseEntity<>(
                new CustomizedResponse<>("201: Added backdrop successfully", backdrop),
                HttpStatus.CREATED
        );
    }

    @PostMapping(value = "/all-backdrops", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CustomizedResponse<Backdrop[]>> addAllBackdrops(@RequestBody Backdrop[] backdrops) {
        backdropService.addAllBackdrops(backdrops);
        return new ResponseEntity<>(
                new CustomizedResponse<>("201: Added backdrops successfully", backdrops),
                HttpStatus.CREATED
        );
    }
}
