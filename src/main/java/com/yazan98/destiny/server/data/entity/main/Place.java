package com.yazan98.destiny.server.data.entity.main;

import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:49 PM
 */

@Entity
@Table(name = "places")
public class Place implements Serializable , VortexBaseEntity {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "category_id")
    private Long categoryId;

    @NonNull
    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "rate")
    private Float rate;

    @NonNull
    @Column(name = "rates")
    private Long rates;

    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "km")
    private Double km;

    @OneToOne(cascade = CascadeType.ALL)
    private PlaceDetails details;

    @NonNull
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "images")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images = new ArrayList<String>();

    public Place() {

    }

    public Place(@NonNull String name, @NonNull Long categoryId, @NonNull String image, @NonNull Float rate, @NonNull Long rates, @NonNull String status, @NonNull Double km, PlaceDetails details) {
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
        this.rate = rate;
        this.rates = rates;
        this.status = status;
        this.km = km;
        this.details = details;
    }

    public List<String> getImages() {
        return images;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Long getRates() {
        return rates;
    }

    public void setRates(Long rates) {
        this.rates = rates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public PlaceDetails getDetails() {
        return details;
    }

    public void setDetails(PlaceDetails details) {
        this.details = details;
    }
}
