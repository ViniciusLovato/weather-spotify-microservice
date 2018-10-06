package com.lovato.weatherspotifymicroservice.service;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;

public interface PlaylistService {

    /**
     *
     * @param city
     * @return
     */
    TrackResponse getTracksByCity(String city);

    /**
     *
     * @param latitude
     * @param longitude
     * @return
     */
    TrackResponse getTracksByLatLon(Double latitude, Double longitude);
}
