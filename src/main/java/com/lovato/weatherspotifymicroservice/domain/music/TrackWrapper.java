package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackWrapper {

    @JsonProperty("track")
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
