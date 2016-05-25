package com.countryclicker.model.Strategy;

import com.countryclicker.model.Strategy.CalculateCostOfKick;

import java.io.Serializable;

/**
 * Created by Илья on 26.05.2016.
 */
public class MissKick implements CalculateCostOfKick, Serializable {
    @Override
    public int calculate() {
        return 0;
    }
}
