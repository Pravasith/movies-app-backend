package com.moviestore.cjv.services;

import com.moviestore.cjv.models.backdrops.Backdrop;
import com.moviestore.cjv.models.backdrops.BackdropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BackdropService {

    @Autowired
    private BackdropRepository backdropRepository;

    public List<Backdrop> getBackdrops() {
        return backdropRepository.findAll();
    }


    public void addBackdrop(Backdrop backdrop) {
        backdropRepository.insert(backdrop);
    }

    public void addAllBackdrops (Backdrop[] backdrops) { backdropRepository.saveAll(Arrays.stream(backdrops).toList()); }
}
