package com.lovato.weatherspotifymicroservice.service.weather;

import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;

public interface WeatherService {

    public WeatherResponse getWeatherByCity(String city);

    public WeatherResponse getWeatherByLatLon(Double latitude, Double longitude);
}
