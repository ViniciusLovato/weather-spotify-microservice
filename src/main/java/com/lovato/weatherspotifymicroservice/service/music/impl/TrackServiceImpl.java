package com.lovato.weatherspotifymicroservice.service.music.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.music.PlaylistClient;
import com.lovato.weatherspotifymicroservice.service.music.TrackService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    PlaylistClient playlistClient;

    @Cacheable(value = "tracks")
    public TrackResponse getTracksByCategory(Category category) {
        PlaylistResponse playlistResponse = playlistClient.getPlaylist(category.getName());

        // Only want the first playlist
        String playlistId = playlistResponse.getPlaylists().get(0).getId();

        return playlistClient.getTracks(playlistId);
    }


}
