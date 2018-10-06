package com.lovato.weatherspotifymicroservice.controller;

import com.lovato.weatherspotifymicroservice.domain.weather.Weather;
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


    @Value("${api.owm.appid}")
    private String appid;

    /**
     *
     * @param city
     * @return
     */
    @RequestMapping("/weather")
    public Weather getWeather(@RequestParam("city") String city) {

        Weather weather = weatherClient.getWeather(city, "metric", appid);


        return weather;
    }
}
