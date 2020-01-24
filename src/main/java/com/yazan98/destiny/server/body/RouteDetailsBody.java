package com.yazan98.destiny.server.body;

import com.yazan98.destiny.server.data.entity.place.route.RouteDetails;
import com.yazan98.destiny.server.data.entity.place.route.RouteStory;

import java.util.List;

public class RouteDetailsBody {

    private List<RouteStory> stories;
    private RouteDetails details;

    public RouteDetailsBody() {

    }

    public RouteDetailsBody(List<RouteStory> stories, RouteDetails details) {
        this.stories = stories;
        this.details = details;
    }

    public List<RouteStory> getStories() {
        return stories;
    }

    public void setStories(List<RouteStory> stories) {
        this.stories = stories;
    }

    public RouteDetails getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "RouteDetailsBody{" +
                "stories=" + stories +
                ", details=" + details +
                '}';
    }

    public void setDetails(RouteDetails details) {
        this.details = details;
    }
}
