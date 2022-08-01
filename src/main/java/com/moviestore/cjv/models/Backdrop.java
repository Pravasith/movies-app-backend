package com.moviestore.cjv.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("backdrops")
public class Backdrop {
    @Id
    private String id;
    private String backdrop;
    private String title;
    private String slug;

    public Backdrop() {
    }

    public Backdrop(String id, String backdrop, String title, String slug) {
        this.id = id;
        this.backdrop = backdrop;
        this.title = title;
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
