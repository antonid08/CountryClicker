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
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;


    AssetsManager assetsManager;
    GameStage stage;

    public Human (GameStage stage){
        this.stage = stage;
        assetsManager = AssetsManager.getInstance();

        setPosition(Constants.HUMAN_X, Constants.HUMAN_Y);
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
        stage.updateMoney(stage.getMoneyPerClick());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
     //  batch.setColor(1, 1, 1, parentAlpha);
       batch.draw(assetsManager.getHumanRegion(), getX(), getY(), getWidth(), getHeight());
    }

 /*   public Actor hit (float x, float y) {
        return x > 0 && x < getWidth() && y > 0 && y < getHeight() ? this : null;
    }*/
}
