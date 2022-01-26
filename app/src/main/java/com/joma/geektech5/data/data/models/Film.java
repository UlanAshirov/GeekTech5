package com.joma.geektech5.data.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Film implements Serializable {
    private String id;
    private String title;
    private String description;
    private String director;
    private String producer;
    private String image;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_title_romanised")
    private String originalTitleRomanised;

    public Film(String id, String title, String description,
                String director, String producer,
                String image, String releaseDate, String originalTitle,
                String originalTitleRomanised) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.image = image;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
        this.originalTitleRomanised = originalTitleRomanised;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginalTitleRomanised() {
        return originalTitleRomanised;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getImage() {
        return image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }


}
