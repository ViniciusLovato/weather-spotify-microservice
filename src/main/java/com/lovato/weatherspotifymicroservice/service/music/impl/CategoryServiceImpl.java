package com.lovato.weatherspotifymicroservice.service.music.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.music.CategoryService;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    WeatherService weatherService;


    public Category getCategoryFromLocation(String city) {
        WeatherResponse ws = weatherService.getWeather(city);
        return getCategoryWeather(ws);

    }

    public Category getCategoryFromLocation(Double lat, Double lon){
        WeatherResponse ws = weatherService.getWeather(lat, lon);
        return getCategoryWeather(ws);
    }

    private Category getCategoryWeather(WeatherResponse ws){
        Double temperature = ws.getWeatherInfo().getTemperature();
        if (temperature > 30)
            return Category.PARTY;
        else if (temperature > 15)
            return Category.POP;
        else if (temperature > 10)
            return Category.ROCK;
        return Category.CLASSICAL;
    }

}
