package com.countryclicker.utils;

/**
 * Created by Илья on 29.03.2016.
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
