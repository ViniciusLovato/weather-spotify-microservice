package com.lovato.weatherspotifymicroservice.service.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.PlaylistClient;
import com.lovato.weatherspotifymicroservice.service.PlaylistService;
import com.lovato.weatherspotifymicroservice.service.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    WeatherClient weatherClient;

    @Autowired
    PlaylistClient playlistClient;

    @Value("${api.owm.appid}")
    private String appid;

    @Override
    public TrackResponse getTracksByCity(String city) {
        WeatherResponse weatherResponse = weatherClient.getWeather(city, "metric", appid);
        return getTracksByWeather(weatherResponse);
    }

    @Override
    public TrackResponse getTracksByLatLon(Double latitude, Double longitude) {
        WeatherResponse weatherResponse = weatherClient.getWeather(latitude, longitude, "metric", appid);
        return getTracksByWeather(weatherResponse);
    }

    private TrackResponse getTracksByWeather(WeatherResponse weather) {
        Category category =  getCategoryFromTemperature(weather.getWeatherInfo().getTemperature());
        PlaylistResponse playlistResponse = playlistClient.getPlaylist(category.getName());

        // TODO refactor - get all playlists or something diff
        String playlistId = playlistResponse.getPlaylistWrapper().getPlaylists().get(0).getId();

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
