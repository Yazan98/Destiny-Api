package com.yazan98.destiny.server.data.entity.main;

import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:32 PM
 */

@Entity
@Table(name = "routs")
public class Route implements Serializable , VortexBaseEntity {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "places")
    private Long places;

    @NonNull
    @Column(name = "type")
    private String type;

    public Route() {

    }

    public Route(String image, String name, Long places, String type) {
        this.image = image;
        this.name = name;
        this.places = places;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlaces() {
        return places;
    }

    public void setPlaces(Long places) {
        this.places = places;
    }
}
