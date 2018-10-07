package com.lovato.weatherspotifymicroservice.service.music;

import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;

public interface TrackService {

    /**
     *
     * @param weather
     * @return
     */
    public TrackResponse getTracksByWeather(WeatherResponse weather);
}
