package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class TrackResponse implements Serializable {

    @JsonProperty("items")
    private List<Track> tracks;

    public List<Track> getTracks() { return tracks; }

    public void setTracks(List<Track> tracks) { this.tracks = tracks; }
}
