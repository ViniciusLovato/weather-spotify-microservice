package com.lovato.weatherspotifymicroservice.service.weather.impl;

import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherClient;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherClient weatherClient;

    @Value("${api.owm.appid}")
    private String appid;

    @Override
    public WeatherResponse getWeatherByCity(String city) {
        return weatherClient.getWeather(city, "metric", appid);
    }

    @Override
    public WeatherResponse getWeatherByLatLon(Double latitude, Double longitude) {

        return weatherClient.getWeather(latitude, longitude, "metric", appid);
    }
}
