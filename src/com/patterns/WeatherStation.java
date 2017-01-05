package com.patterns;

import com.patterns.observer.CurrentConditionDisplay;
import com.patterns.observer.HeatIndexDisplay;
import com.patterns.observer.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
	// write your code here
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        weatherData.setMeasurement(80,90,75.5f);
        weatherData.setMeasurement(87,90,85.5f);
    }
}
