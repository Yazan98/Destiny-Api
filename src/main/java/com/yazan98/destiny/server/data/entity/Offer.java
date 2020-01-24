package com.yazan98.destiny.server.data.entity;

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "offers")
public class Offer extends VortexMysqlEntity implements Serializable {

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
    @Column(name = "discount")
    private Double discount;

    public Offer() {
    }

    public Offer(String name, String image, Double discount) {
        this.discount = discount;
        this.image = image;
        this.name = name;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
