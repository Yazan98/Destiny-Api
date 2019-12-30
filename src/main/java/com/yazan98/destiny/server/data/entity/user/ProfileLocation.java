package com.yazan98.destiny.server.data.entity.user;

import lombok.NonNull;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:27 AM
 */

@Entity
@Table(name = "accounts_locations")
public class ProfileLocation implements Serializable {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "latitude")
    private Double latitude;

    @NonNull
    @Column(name = "longitude")
    private Double longitude;

    @OneToOne
    private Profile profile;

    public ProfileLocation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
