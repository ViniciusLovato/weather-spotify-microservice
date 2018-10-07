package com.lovato.weatherspotifymicroservice.controller;

import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.service.PlaylistClient;
import com.lovato.weatherspotifymicroservice.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private PlaylistClient playlistClient;


    /**
     *
     * @param city
     * @return
     */
    @RequestMapping("/playlist")
    public TrackResponse getTracksByCity(@RequestParam("city") String city) {
        return playlistService.getTracksByCity(city);
    }

    @RequestMapping("/test")
    public PlaylistResponse test(@RequestParam("category") String category) {
        return playlistClient.getPlaylist(category);
    }


}
