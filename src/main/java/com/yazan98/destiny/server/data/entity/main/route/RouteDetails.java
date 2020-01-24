package com.yazan98.destiny.server.data.entity.main.route;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "route_details")
public class RouteDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "location")
    private String location;

    @Column(name = "background")
    private String background;

    @Column(name = "icon")
    private String icon;

    @Column(name = "full_des")
    private String fullDescription;

    private Long routeId;

    @Column(name = "rating")
    private Float rating;

    public RouteDetails() {
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", location='" + location + '\'' +
                ", background='" + background + '\'' +
                ", icon='" + icon + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", routeId=" + routeId +
                ", rating=" + rating +
                '}';
    }
}
