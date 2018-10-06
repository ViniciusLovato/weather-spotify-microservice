package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrackResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("items")
    private List<TrackWrapper> trackWrappers;

    public List<TrackWrapper> getTrackWrappers() {
        return trackWrappers;
    }

    public void setTrackWrappers(List<TrackWrapper> trackWrappers) {
        this.trackWrappers = trackWrappers;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
