package com.countryclicker.utils;

/**
 * Created by Илья on 29.03.2016.
 */
public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
