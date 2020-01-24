package com.yazan98.destiny.server.data.entity.main.route;

import com.yazan98.destiny.server.data.entity.user.Profile;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "route_comments")
public class RouteComments implements Serializable {

    @Id
    @NonNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "comment")
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    @NonNull
    @Column(name = "route_id")
    private Long routeId;

    public RouteComments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}
