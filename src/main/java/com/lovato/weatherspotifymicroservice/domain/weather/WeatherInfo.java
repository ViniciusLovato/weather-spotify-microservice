package com.lovato.weatherspotifymicroservice.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {

    @JsonProperty("temp")
    private Double temperature;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
