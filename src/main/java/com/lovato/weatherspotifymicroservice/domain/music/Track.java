package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class Track {

    private String name;

    @JsonProperty("track")
    private void unpackNameFromNestedObject(Map<String, Object> track) {
        this.name = track.get("name").toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
