package com.yazan98.destiny.server.data.entity;

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "foods")
public class Food extends VortexMysqlEntity implements Serializable {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "price")
    private Double price;

    @NonNull
    @Column(name = "is_promoted")
    private boolean isPromoted;

    @NonNull
    @Column(name = "ratings")
    private Float rating;

    @NonNull
    @Column(name = "votes")
    private Long votes;

    @NonNull
    @Column(name = "time")
    private String time;

    @NonNull
    @Column(name = "gms")
    private String gms;

    @NonNull
    @Column(name = "full_description")
    private String fullDescription;

    @NonNull
    @Column(name = "num_of_p")
    private String numberOfPieces;

    @NonNull
    @Column(name = "popular")
    private boolean isPopular;

    @NonNull
    @Column(name = "categoryId")
    private Long categoryId = 1L;

    public Food() {

    }

    public Food(String name, String image, String description, Double price, boolean isPromoted, Float rating,
                Long votes, String time, String gms, String fullDescription, String numberOfPieces, boolean isPopular, Long id) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.isPromoted = isPromoted;
        this.rating = rating;
        this.votes = votes;
        this.time = time;
        this.gms = gms;
        this.fullDescription = fullDescription;
        this.numberOfPieces = numberOfPieces;
        this.isPopular = isPopular;
        categoryId = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGms() {
        return gms;
    }

    public void setGms(String gms) {
        this.gms = gms;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(String numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean popular) {
        isPopular = popular;
    }

}
