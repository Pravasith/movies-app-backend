package com.moviestore.cjv.services;

import com.moviestore.cjv.models.media.Media;
import com.moviestore.cjv.models.media.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Media> getAllMedia(){
        return mediaRepository.findAll();
    }

    public void addMedia(Media media) {
        mediaRepository.insert(media);
    }

    public void addAllMovies(Media[] media) {
        mediaRepository.saveAll(Arrays.stream(media).toList());
    }

    public List<Media> getMediaByType (String mediaType)
    {
        Query query = new Query();
        query.addCriteria(
            Criteria
                .where("mediaType")
                .is(mediaType)
        );

        final List<Media> media = mongoTemplate.find(query, Media.class);

        return media;
    }

    public List<Media> getFeaturedMediaByType (String mediaType)
    {
        Query query = new Query();
        query.addCriteria(
            Criteria
                .where("mediaType")
                .is(mediaType)
                .and("isFeatured")
                .is(true)
        );

        final List<Media> media = mongoTemplate.find(query, Media.class);

        return media;
    }

    public List<Media> getMediaHavingName(String name)
    {
        Query query = new Query();
        query.addCriteria(
            Criteria
                .where("name")
                .regex(".*" + name + ".*", "i")
        );

        final List<Media> media = mongoTemplate.find(query, Media.class);

        return media;
    }
}
