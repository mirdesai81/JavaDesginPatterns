package com.patterns.observer;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
