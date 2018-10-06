package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Track {

    @JsonProperty("name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
