package com.lovato.weatherspotifymicroservice.domain.music;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaylistResponse {

    @JsonProperty("playlists")
    private PlaylistWrapper playlistWrapper;

    public PlaylistWrapper getPlaylistWrapper() {
        return playlistWrapper;
    }

    public void setPlaylistWrapper(PlaylistWrapper playlistWrapper) {
        this.playlistWrapper = playlistWrapper;
    }
}
