package com.lovato.weatherspotifymicroservice.service.weather;

import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;

import com.lovato.weatherspotifymicroservice.service.weather.impl.WeatherClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "owm-service", url = "${api.own.url}", fallback = WeatherClientFallback.class)
public interface WeatherClient {

    /**
     *
     * @param city
     * @param units
     * @param appid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    WeatherResponse getWeather(@RequestParam("q") String city, @RequestParam("units") String units,
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
    WeatherResponse getWeather(@RequestParam("lat") Double latitude, @RequestParam("lon") Double longitude,
                               @RequestParam("units") String units, @RequestParam("appid") String appid);

}
