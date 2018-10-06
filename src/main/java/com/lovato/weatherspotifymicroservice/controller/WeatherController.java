package com.lovato.weatherspotifymicroservice.controller;

import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.PlaylistClient;
import com.lovato.weatherspotifymicroservice.service.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController  {

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private PlaylistClient playlistClient;

    @Value("${api.owm.appid}")
    private String appid;

    /**
     *
     * @param city
     * @return
     */
    @RequestMapping("/weather")
    public WeatherResponse getWeather(@RequestParam("city") String city) {
        return weatherClient.getWeather(city, "metric", appid);
    }

    /**
     *
     * @param category
     * @return
     */
    @RequestMapping("/playlist")
    public PlaylistResponse getPlaylist(@RequestParam("category") String category) {
        return playlistClient.getPlaylist(category);
    }
}
