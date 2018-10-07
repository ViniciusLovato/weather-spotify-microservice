package com.lovato.weatherspotifymicroservice.controller;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.service.music.TrackService;
import com.lovato.weatherspotifymicroservice.service.weather.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private CategoryService CategoryService;

    /**
     *
     * @param city
     * @return
     */

    @RequestMapping("/tracks")
    public TrackResponse getTracksByCity(@RequestParam("city") String city) {
        Category category = CategoryService.getCategoryFromLocation(city);
        return trackService.getTracksByCategory(category);
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    @RequestMapping("/tracksByCoordinates")
    public TrackResponse getTracksByLatLon(@RequestParam("lat") Double lat, @RequestParam Double lon) {
        Category category = CategoryService.getCategoryFromLocation(lat, lon);
        return trackService.getTracksByCategory(category);
    }
}
