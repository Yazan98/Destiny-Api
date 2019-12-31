package com.yazan98.destiny.server.data.entity.category;

import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 5:18 PM
 */

@Entity
@Table(name = "categories")
public class Category implements Serializable, VortexBaseEntity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "icon")
    private String icon;

    @NonNull
    @Column(name = "background")
    private String background;

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name="images")
    @ElementCollection(targetClass=String.class , fetch = FetchType.EAGER)
    private List<String> images;

    public Category() {

    }

    public Category(@NonNull String name, @NonNull String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }

    public String getBackground() {
        return background;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
