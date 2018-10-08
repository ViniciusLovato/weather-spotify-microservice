package com.lovato.weatherspotifymicroservice.service.music.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Playlist;
import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.music.Track;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.service.music.PlaylistClient;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;
import java.util.ArrayList;

@Component
public class PlaylistClientFallback implements PlaylistClient {

    @Override
    public PlaylistResponse getPlaylist(String category) {

        Playlist playlist = new Playlist();
        playlist.setId("fallback id");
        playlist.setName("fallback name");

        PlaylistResponse playlistResponse = new PlaylistResponse();
        playlistResponse.setPlaylists(new ArrayList<Playlist>(asList(playlist)));
        return playlistResponse;
    }

    @Override
    public TrackResponse getTracks(String playListId) {

        Track track = new Track();
        track.setName("fallback track");

        TrackResponse trackResponse = new TrackResponse();
        trackResponse.setTracks(new ArrayList<Track>(asList(track)));

        return trackResponse;
    }

}
