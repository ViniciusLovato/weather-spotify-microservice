package com.lovato.weatherspotifymicroservice.service;

import com.lovato.weatherspotifymicroservice.domain.weather.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "owm", url = "http://api.openweathermap.org/data/2.5")
public interface WeatherClient {

    /**
     *
     * @param city
     * @param units
     * @param appid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    Weather getWeather(@RequestParam("q") String city, @RequestParam("units") String units,
                        @RequestParam("appid") String appid);

    /**
     *
     * @param latitude
     * @param longitude
     * @param units
     * @param appid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    Weather getWeather(@RequestParam("lat") Double latitude, @RequestParam("lon") Double longitude,
                         @RequestParam("units") String units, @RequestParam("appid") String appid);

}
