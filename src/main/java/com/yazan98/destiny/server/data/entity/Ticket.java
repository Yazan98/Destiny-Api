package com.yazan98.destiny.server.data.entity;

import com.yazan98.destiny.server.data.entity.main.PlaceDetails;
import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 10:57 PM
 */

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable , VortexBaseEntity {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "place_name")
    private String placeName;

    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @NonNull
    @Column(name = "place_id")
    private Long placeId;

    @NonNull
    @Column(name = "date")
    private String date = new Date().toString();

    @NonNull
    @Column(name = "place_image")
    private String placeImage;

    @NonNull
    @Column(name = "address_info")
    private String addressInfo;

    @OneToOne
    private PlaceDetails details;

    @NonNull
    @Column(name = "ticket_number")
    private String ticketNumber = UUID.randomUUID().toString();

    public Ticket() {

    }

    public Ticket(@NonNull String placeName, @NonNull Long userId, @NonNull Long placeId, @NonNull String date, @NonNull String placeImage, @NonNull String addressInfo, PlaceDetails details, @NonNull String ticketNumber) {
        this.placeName = placeName;
        this.userId = userId;
        this.placeId = placeId;
        this.date = date;
        this.placeImage = placeImage;
        this.addressInfo = addressInfo;
        this.details = details;
        this.ticketNumber = ticketNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(String placeImage) {
        this.placeImage = placeImage;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public PlaceDetails getDetails() {
        return details;
    }

    public void setDetails(PlaceDetails details) {
        this.details = details;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
