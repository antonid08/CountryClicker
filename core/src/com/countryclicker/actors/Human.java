package com.countryclicker.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 29.02.2016.
 */
public class Human extends Actor implements Serializable{
    private static final float COEF = 1.22f;
    private static final int HEIGHT = 250;
    private static final int WIDTH = (int)(HEIGHT * COEF);
    private static final int X = 40;
    private static final int Y = 420;


    enum State {
        NORMAL,
        KICKED
    }

    AssetsManager assetsManager;
    GameStage stage;

    private State state;
    private float animationTime;

    public Human (GameStage stage){
        this.stage = stage;
        assetsManager = AssetsManager.getInstance();

        state = State.NORMAL;
        animationTime = 0;

        setPosition(X, Y);
        setSize(WIDTH, HEIGHT);

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

    }

    public void onClick(){
        state = State.KICKED;
        stage.updateMoney(stage.getMoneyPerClick());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
     //  batch.setColor(1, 1, 1, parentAlpha);
       //batch.draw(assetsManager.getHumanAnimation().getKeyFrame(animationTime), getX(), getY(), getWidth(), getHeight());
        batch.draw(assetsManager.getHumanAnimation().getKeyFrame(0), getX(), getY(), getWidth(), getHeight());
    }

    @Override
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
