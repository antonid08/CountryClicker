package com.countryclicker.utils;

import com.countryclicker.model.World;

/**
 * Created by Илья on 08.05.2016.
 */
public interface ModelSubscriber {
    public void modelChanged(World world);
}
