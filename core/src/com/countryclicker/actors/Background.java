package com.countryclicker.actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 01.05.2016.
 */
public class Background extends Image {
    private static final int WIDTH = Constants.APP_WIDTH;
    private static final int HEIGHT = Constants.APP_HEIGHT;
    private static final int X = 0;
    private static final int Y = 0;


    GameStage stage;
    AssetsManager assetsManager;

    public Background(GameStage stage){
        this.stage = stage;
        assetsManager = AssetsManager.getInstance();
        setUpBounds();
    }

    private void setUpBounds(){
        setX(X);
        setY(Y);
        setWidth(WIDTH);
        setHeight(HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(assetsManager.getBackground(), getX(), getY(), getWidth(), getHeight());
    }
}
