package com.countryclicker.model;

import com.countryclicker.model.Strategy.CalculateCostOfKick;
import com.countryclicker.model.Strategy.DoubleKick;
import com.countryclicker.model.Strategy.MissKick;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 29.02.2016.
 */
public class Human implements Serializable{
    public CalculateCostOfKick calc;
    private DoubleKick dk;
    private MissKick mk;


    public enum State {
        NORMAL,
        KICKED
    }

    private int moneyPerClick = 1;

    private World world;

    public State state;  //TODO TRY TO MAKE IT PRIVATE
    private float animationTime;

    public Human (World world){
        dk = new DoubleKick();
        mk  = new MissKick();
        calc = mk;

        state = State.NORMAL;
        animationTime = 0;

        this.world = world;
    }

    public void update(float delta) {
        if (state == State.KICKED) {
            animationTime += delta;
            if (animationTime > Constants.HUMAN_HIT_ANIMATION_TIME) {
                state = State.NORMAL;
                animationTime = 0;
            }
        }
    }


    public float getMoneyForKick(int number){
        if (number % 2 == 0) {
            calc = dk;
        }else{
            calc = mk;
        }
        return calc.calculate();
    }

    public int getMoneyPerClick(){
        return moneyPerClick;
    }

    public float getAnimationTime(){ //DO NOT REMOVE!!
        return animationTime;
    }
 /*   public Actor hit (float x, float y) {
        return x > 0 && x < getWidth() && y > 0 && y < getHeight() ? this : null;
    }*/
}
