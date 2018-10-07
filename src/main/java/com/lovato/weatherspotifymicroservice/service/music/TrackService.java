package com.lovato.weatherspotifymicroservice.service.music;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.music.TrackResponse;


public interface TrackService {

    /**
     *
     * @param category
     * @return
     */
    public TrackResponse getTracksByCategory(Category category);
}
