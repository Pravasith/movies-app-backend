package com.moviestore.cjv.services;

import com.moviestore.cjv.models.media.Media;
import com.moviestore.cjv.models.media.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public List<Media> getAllMedia(){
        return mediaRepository.findAll();
    }

    public void addMedia(Media media) {
        mediaRepository.insert(media);
    }

    public void addAllMovies(Media[] media) {
        mediaRepository.saveAll(Arrays.stream(media).toList());
    }
}
