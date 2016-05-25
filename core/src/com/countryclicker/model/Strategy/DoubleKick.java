package com.countryclicker.model.Strategy;

import java.io.Serializable;

/**
 * Created by Илья on 26.05.2016.
 */
public class DoubleKick implements CalculateCostOfKick, Serializable {
    @Override
    public int calculate() {
        return 2;
    }
}
