package com.countryclicker.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 29.02.2016.
 */
public class Human implements Serializable{

    public enum State {
        NORMAL,
        KICKED
    }

    private int moneyPerClick = 1;

    private World world;

    public State state;  //TODO TRY TO MAKE IT PRIVATE
    private float animationTime;

    public Human (World world){
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
