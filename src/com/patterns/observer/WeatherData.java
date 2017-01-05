package com.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {

    }


    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurement(float temp,float humidity, float pressure) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementChanged();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}
