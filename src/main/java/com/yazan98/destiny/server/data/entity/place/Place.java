package com.yazan98.destiny.server.data.entity.place;

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
    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private PlaceDetails details;

    @NonNull
    @Column(name = "city_id")
    private Long cityId;

    public Place() {

    }

    public Place(@NonNull String name, @NonNull String image, @NonNull String status, PlaceDetails details) {
        this.name = name;
        this.image = image;
        this.status = status;
        this.details = details;
    }


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PlaceDetails getDetails() {
        return details;
    }

    public void setDetails(PlaceDetails details) {
        this.details = details;
    }
}
