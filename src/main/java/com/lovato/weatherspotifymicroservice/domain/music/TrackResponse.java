package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;


public class TrackResponse {

    @JsonProperty("items")
    private List<Track> tracks;

    public List<Track> getTracks() { return tracks; }

    public void setTracks(List<Track> tracks) { this.tracks = tracks; }
}
