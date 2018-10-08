package com.lovato.weatherspotifymicroservice.service.music;

import com.lovato.weatherspotifymicroservice.config.PlaylistClientConfig;
import com.lovato.weatherspotifymicroservice.domain.music.PlaylistResponse;

import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;
import com.lovato.weatherspotifymicroservice.service.music.impl.PlaylistClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify-service", url = "${api.spotify.url}", configuration = PlaylistClientConfig.class, fallback = PlaylistClientFallback.class)
public interface PlaylistClient {


    @RequestMapping(method = RequestMethod.GET, value="/browse/categories/{category}/playlists")
    PlaylistResponse getPlaylist(@RequestParam("category") String category);


    @RequestMapping(method = RequestMethod.GET, value="/playlists/{playlist_id}/tracks")
    TrackResponse getTracks(@RequestParam("playlist_id") String playListId);
}
