package com.yazan98.destiny.server.data.entity;

import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 7:23 PM
 */

@Entity
@Table(name = "cities")
public class City implements Serializable , VortexBaseEntity {

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

    public City() {

    }

    public City(@NonNull String image, @NonNull String name) {
        this.image = image;
        this.name = name;
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

}
