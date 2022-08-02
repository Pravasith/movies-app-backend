package com.moviestore.cjv.services;

import com.moviestore.cjv.models.media.Media;
import com.moviestore.cjv.models.media.MediaRepository;
import com.moviestore.cjv.models.users.User;
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

    public Optional<Media> getMediaById(String id) throws Exception
    {
        Optional<Media> media = mediaRepository.findById(id);

        if(!media.isPresent()) {
            throw new Exception("Media with Id: " + id + " not found");
        }

        return media;
    }

    public Media updateMediaById(String id, Media newMedia) throws Exception
    {
        // Missing Fields Validation
        if(
            id == null ||
            id.equals("") ||
            newMedia.getName() == null ||
            newMedia.getPrice() == null ||
            newMedia.getSynopsis()  == null ||
            newMedia.getMediaType()  == null ||
            newMedia.getSmallPoster()  == null ||
            newMedia.getLargePoster()  == null ||
            newMedia.getRentPrice()  == null ||
            newMedia.getPurchasePrice() == null ||
            newMedia.getSlug() == null
        )
        {
            throw new Exception("Missing fields in the Media Object");
        }

        // Retrieving the Object by ID from the DB
        Optional<Media> media = mediaRepository.findById(id);

        // Validating ID
        if(media.isEmpty()) {
            throw new Exception("Media with Id: " + id + " not found");
        }

        // Setting new fields
        media.get().setName(newMedia.getName());
        media.get().setName(newMedia.getName());
        media.get().setPrice(newMedia.getPrice());
        media.get().setSynopsis(newMedia.getSynopsis());
        media.get().setMediaType(newMedia.getMediaType());
        media.get().setSmallPoster(newMedia.getSmallPoster());
        media.get().setLargePoster(newMedia.getLargePoster());
        media.get().setRentPrice(newMedia.getRentPrice());
        media.get().setPurchasePrice(newMedia.getPurchasePrice());
        media.get().setSlug(newMedia.getSlug());

        // Saving to the DB
        Media savedMedia = mediaRepository.save(media.get());

        return savedMedia;
    }
}
