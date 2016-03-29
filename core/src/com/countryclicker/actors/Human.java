package com.countryclicker.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 29.02.2016.
 */
public class Human extends Actor {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;


    TextureRegion region;

    GameStage stage;

    public Human (GameStage stage){
        this.stage = stage;

        region = new TextureRegion(new Texture(Gdx.files.internal("human.png")), 0, 0, 128, 128);

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
       batch.draw(region, getX(), getY(), getWidth(), getHeight());
    }

 /*   public Actor hit (float x, float y) {
        return x > 0 && x < getWidth() && y > 0 && y < getHeight() ? this : null;
    }*/
}
