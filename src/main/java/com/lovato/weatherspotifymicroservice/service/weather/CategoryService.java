package com.lovato.weatherspotifymicroservice.service.weather;

import com.lovato.weatherspotifymicroservice.domain.music.Category;

public interface CategoryService {

    public Category getCategoryFromLocation(String city);

    public Category getCategoryFromLocation(Double lat, Double lon);
}
