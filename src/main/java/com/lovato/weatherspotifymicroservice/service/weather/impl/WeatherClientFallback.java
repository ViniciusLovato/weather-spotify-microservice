package com.lovato.weatherspotifymicroservice.service.weather.impl;

import com.lovato.weatherspotifymicroservice.domain.weather.WeatherInfo;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherClient;
import org.springframework.stereotype.Component;

@Component
public class WeatherClientFallback implements WeatherClient {
    @Override
    public WeatherResponse getWeather(String city, String units, String appid) {
        return defaultWeatherResponse();
    }

    @Override
    public WeatherResponse getWeather(Double latitude, Double longitude, String units, String appid) {
        return defaultWeatherResponse();
    }

    private  WeatherResponse defaultWeatherResponse(){
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName("fallback weather");
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setTemperature(1.0);
        weatherResponse.setWeatherInfo(weatherInfo);
        return weatherResponse;
    }
}
