package com.lovato.weatherspotifymicroservice.service;

import com.lovato.weatherspotifymicroservice.config.PlaylistClientConfig;
import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify-service", url = "https://api.spotify.com/v1/", configuration = PlaylistClientConfig.class)
public interface PlaylistClient {

    /**
     *
     * @param category
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value="/browse/categories/{category}/playlists")
    PlaylistResponse getPlaylist(@RequestParam("category") String category);


}
