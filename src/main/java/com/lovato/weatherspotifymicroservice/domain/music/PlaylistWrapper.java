package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlaylistWrapper {

    @JsonProperty("items")
    private List<Playlist> playlists;

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

}
