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

    @Cacheable(value = "tracks", key = "#weather.getName()")
    public TrackResponse getTracksByWeather(WeatherResponse weather) {

        Category category =  getCategoryFromTemperature(weather.getWeatherInfo().getTemperature());
        PlaylistResponse playlistResponse = playlistClient.getPlaylist(category.getName());

        // Only want the first playlist
        String playlistId = playlistResponse.getPlaylists().get(0).getId();

        return playlistClient.getTracks(playlistId);
    }

    private Category getCategoryFromTemperature(Double temperature) {
        if (temperature > 30)
            return Category.PARTY;
        else if (temperature > 15)
            return Category.POP;
        else if (temperature > 10)
            return Category.ROCK;
        return Category.CLASSICAL;
    }
}
