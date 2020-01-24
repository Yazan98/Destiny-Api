package com.yazan98.destiny.server.data.entity.place;

import lombok.NonNull;

import javax.persistence.*;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 6:52 PM
 */

@Entity
@Table(name = "places_details")
public class PlaceDetails {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "latitude")
    private Double latitude;

    @NonNull
    @Column(name = "longitude")
    private Double longitude;

    @OneToOne
    private Place place;

    @OneToOne
    private Ticket ticket;

    public PlaceDetails() {

    }

    public PlaceDetails(@NonNull Double latitude, @NonNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
