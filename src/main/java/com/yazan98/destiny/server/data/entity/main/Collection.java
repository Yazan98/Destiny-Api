package com.yazan98.destiny.server.data.entity.main;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:38 PM
 */

@Entity
@Table(name = "collections")
public class Collection implements Serializable , VortexBaseEntity {

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
    @Column(name = "exhibits")
    private Long exhibits;

    @NonNull
    @Column(name = "promoted")
    private Boolean isPromoted;

    public Collection() {

    }

    public Collection(@NonNull String image, @NonNull String name, @NonNull Long exhibits, @NonNull Boolean isPromoted) {
        this.image = image;
        this.name = name;
        this.exhibits = exhibits;
        this.isPromoted = isPromoted;
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

    public Long getExhibits() {
        return exhibits;
    }

    public void setExhibits(Long exhibits) {
        this.exhibits = exhibits;
    }

    public Boolean getPromoted() {
        return isPromoted;
    }

    public void setPromoted(Boolean promoted) {
        isPromoted = promoted;
    }
}
