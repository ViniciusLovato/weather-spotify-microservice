package com.lovato.weatherspotifymicroservice.service.music.impl;

import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.service.music.PlaylistClient;
import org.springframework.stereotype.Component;

@Component
public class PlaylistClientFallback implements PlaylistClient {

    @Override
    public PlaylistResponse getPlaylist(String category) {
        return null;
    }

    @Override
    public TrackResponse getTracks(String playListId) {
        return null;
    }
}
