package com.lovato.weatherspotifymicroservice.service.weather.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherInfo;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherClient mWeatherClient;

    @InjectMocks
    private WeatherServiceImpl weatherServiceImpl;

    @Mock
    private WeatherInfo mWeatherInfo;

    private WeatherResponse ws;

    @Before
    public void setup(){
        ws = new WeatherResponse();
        ws.setWeatherInfo(mWeatherInfo);
    }

    @Test
    public void getWeather() {
        // given
        when(mWeatherClient.getWeather("campinas", "metrics", null)).thenReturn(ws);
        WeatherResponse weatherResponse = weatherServiceImpl.getWeather("campinas");
        verify(mWeatherClient, times(1)).getWeather("campinas", "metric", null);
    }

    @Test
    public void getWeather1() {
        when(mWeatherClient.getWeather(20.0, 20.0, "metrics", null)).thenReturn(ws);
        WeatherResponse weatherResponse = weatherServiceImpl.getWeather(20.0, 20.0);
        verify(mWeatherClient, times(1)).getWeather(20.0, 20.0, "metric", null);
    }
}