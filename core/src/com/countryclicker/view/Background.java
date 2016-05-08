package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.view.GameStage;
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

    public Background(GameStage stage){
        super(AssetsManager.getInstance().getBackground());
        this.stage = stage;

        setUpBounds();
    }

    private void setUpBounds(){
        setX(X);
        setY(Y);
        setWidth(WIDTH);
        setHeight(HEIGHT);

    }

}
