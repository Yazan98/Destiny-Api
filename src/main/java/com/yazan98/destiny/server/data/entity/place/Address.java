package com.yazan98.destiny.server.data.entity.place;

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address extends VortexMysqlEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long profileId;

    @OneToOne(cascade = CascadeType.ALL)
    private PlaceDetails details;

    public Address() {
    }

    public Address(String name, Long profileId, PlaceDetails details) {
        this.name = name;
        this.profileId = profileId;
        this.details = details;
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public PlaceDetails getDetails() {
        return details;
    }

    public void setDetails(PlaceDetails details) {
        this.details = details;
    }
}
