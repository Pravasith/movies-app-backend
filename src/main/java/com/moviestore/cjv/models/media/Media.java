package com.moviestore.cjv.models.media;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("media")
public class Media {
    @Id
    private String id;
    private String name;
    private Float price;
    private String synopsis;
    private String mediaType;
    private String smallPoster;
    private String largePoster;
    private Float rentPrice;
    private Float purchasePrice;
    private boolean isFeatured;
    private String slug;

    public Media () {}

    public Media (
        String id,
        String name,
        Float price,
        String synopsis,
        String mediaType,
        String smallPoster,
        String largePoster,
        Float rentPrice,
        Float purchasePrice,
        boolean isFeatured,
        String slug
    )
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.synopsis = synopsis;
        this.mediaType = mediaType;
        this.smallPoster = smallPoster;
        this.largePoster = largePoster;
        this.rentPrice = rentPrice;
        this.purchasePrice = purchasePrice;
        this.isFeatured = isFeatured;
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getSmallPoster() {
        return smallPoster;
    }

    public void setSmallPoster(String smallPoster) {
        this.smallPoster = smallPoster;
    }

    public String getLargePoster() {
        return largePoster;
    }

    public void setLargePoster(String largePoster) {
        this.largePoster = largePoster;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", synopsis='" + synopsis + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", smallPoster='" + smallPoster + '\'' +
                ", largePoster='" + largePoster + '\'' +
                ", rentPrice=" + rentPrice +
                ", purchasePrice=" + purchasePrice +
                ", isFeatured=" + isFeatured +
                ", slug='" + slug + '\'' +
                '}';
    }
}
