package com.patterns.observer;

import java.util.*;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class CurrentConditionDisplay implements DisplayElement, java.util.Observer {
    private Observable _observable;
    private float temp;
    private float humidity;

    public CurrentConditionDisplay(Observable weatherData) {
        this._observable = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Temperature:"+temp+" ,humidity:"+humidity);
    }

    @Override
    public void update(Observable observable,Object o) {

        if(observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
