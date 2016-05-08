package com.countryclicker.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 29.02.2016.
 */
public class Human{

    enum State {
        NORMAL,
        KICKED
    }

    private int moneyPerClick = 1;

    private World world;

    private State state;
    private float animationTime;

    public Human (World world){
        state = State.NORMAL;
        animationTime = 0;

        this.world = world;
    }

    public void onClick(){
        state = State.KICKED;
        world.updateMoney(moneyPerClick);
    }

/*    @Override
    public void draw(Batch batch, float parentAlpha) {
     //  batch.setColor(1, 1, 1, parentAlpha);
       //batch.draw(assetsManager.getHumanAnimation().getKeyFrame(animationTime), getX(), getY(), getWidth(), getHeight());
        batch.draw(assetsManager.getHumanAnimation().getKeyFrame(0), getX(), getY(), getWidth(), getHeight());
    }*/

    public void act(float delta) {
        if (state == State.KICKED) {
            animationTime += delta;
            if (animationTime > Constants.HUMAN_HIT_ANIMATION_TIME) {
                state = State.NORMAL;
                animationTime = 0;
            }
        }
    }

 /*   public Actor hit (float x, float y) {
        return x > 0 && x < getWidth() && y > 0 && y < getHeight() ? this : null;
    }*/
}
