package com.countryclicker.actors.hud;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 22.03.2016.
 */
public class Money extends Actor {
    private int lengthOfMonth;
    private int timeFromPreviousMonth;

    private GameManager gameManager;

    public Money(){
        gameManager = GameManager.getInstance();

        timeFromPreviousMonth = 0;

        lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    }

    @Override
    public void act(float delta) {
        timeFromPreviousMonth += delta;
        if (timeFromPreviousMonth >= lengthOfMonth){
            timeFromPreviousMonth = 0;
            gameManager.updateMoney(gameManager.getMoneyForMonth());
        }
    }

}
