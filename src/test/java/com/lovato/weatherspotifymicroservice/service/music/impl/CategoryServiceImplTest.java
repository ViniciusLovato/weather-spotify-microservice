package com.lovato.weatherspotifymicroservice.service.music.impl;

import com.lovato.weatherspotifymicroservice.domain.music.Category;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherInfo;
import com.lovato.weatherspotifymicroservice.domain.weather.WeatherResponse;
import com.lovato.weatherspotifymicroservice.service.weather.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @Mock
    private WeatherService weatherServiceMock;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    @Mock
    private WeatherInfo mWeatherInfo;

    private WeatherResponse ws;

    @Before
    public void setup(){
        ws = new WeatherResponse();
        ws.setWeatherInfo(mWeatherInfo);
    }

    @Test
    public void getCorrectCategoryFromLocationCity() {
        when(mWeatherInfo.getTemperature()).thenReturn(20.0);
        when(weatherServiceMock.getWeather("Campinas")).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation("Campinas");
        assertEquals("When temperature is 20 category should be ROCK", Category.POP, category);
    }

    @Test
    public void getCorrectCategoryFromLocationCoordinates() {
        when(mWeatherInfo.getTemperature()).thenReturn(40.0);
        when(weatherServiceMock.getWeather(20.0, 20.0)).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation(20.0, 20.0);
        assertEquals("When temperature is 20 category should be Party", Category.PARTY, category);
    }

    @Test
    public void getCorrectPartyCategory() {
        when(mWeatherInfo.getTemperature()).thenReturn(31.0);
        when(weatherServiceMock.getWeather("Campinas")).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation("Campinas");
        assertEquals("When temperature is 20 category should be ROCK", Category.PARTY, category);
    }

    @Test
    public void getCorrectPopCategory() {
        when(mWeatherInfo.getTemperature()).thenReturn(16.0);
        when(weatherServiceMock.getWeather("Campinas")).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation("Campinas");
        assertEquals("When temperature is 20 category should be ROCK", Category.POP, category);
    }

    @Test
    public void getCorrectRockCategory() {
        when(mWeatherInfo.getTemperature()).thenReturn(13.0);
        when(weatherServiceMock.getWeather("Campinas")).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation("Campinas");
        assertEquals("When temperature is 20 category should be ROCK", Category.ROCK, category);
    }

    @Test
    public void getCorrectClassicalCategory() {
        when(mWeatherInfo.getTemperature()).thenReturn(5.0);
        when(weatherServiceMock.getWeather("Campinas")).thenReturn(ws);
        Category category = categoryServiceImpl.getCategoryFromLocation("Campinas");
        assertEquals("When temperature is 20 category should be ROCK", Category.CLASSICAL, category);
    }
}
