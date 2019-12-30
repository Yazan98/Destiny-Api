package com.yazan98.destiny.server.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:27 AM
 */

@Document(collection = "accounts_locations")
public class ProfileLocation implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    @NonNull
    @Indexed(name = "latitude")
    private Double latitude;

    @NonNull
    @Indexed(name = "longitude")
    private Double longitude;

    public ProfileLocation() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
