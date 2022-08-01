package com.moviestore.cjv.controllers;

import com.moviestore.cjv.models.Backdrop;
import com.moviestore.cjv.services.BackdropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class BackdropController {
    @Autowired
    private BackdropService backdropService;

    @GetMapping("/backdrops")
    public List<Backdrop> getBackdrops() {
        return backdropService.getBackdrops();
    }

    @PostMapping(value = "/backdrops", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public void addBackdrop(@RequestBody Backdrop backdrop) {
        backdropService.addBackdrop(backdrop);
    }
}
