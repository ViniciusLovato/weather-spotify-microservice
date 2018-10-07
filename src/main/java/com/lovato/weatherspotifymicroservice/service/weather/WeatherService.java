package com.lovato.weatherspotifymicroservice.service.weather;

import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;

public interface WeatherService {

    public WeatherResponse getWeather(String city);

    public WeatherResponse getWeather(Double latitude, Double longitude);

}
