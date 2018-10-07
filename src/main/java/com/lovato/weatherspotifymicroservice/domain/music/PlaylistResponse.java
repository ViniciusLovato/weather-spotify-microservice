package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.*;

import java.util.List;


@JsonTypeName(value = "playlists")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PlaylistResponse {

    @JsonProperty("items")
    private List<Playlist> playlists;


    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
