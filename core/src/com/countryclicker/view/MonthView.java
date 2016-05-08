package com.countryclicker.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 06.05.2016.
 */
public class MonthView extends ProgressBar {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 30;
    public static final int RECTANGLE_BORDER = 3;


    public MonthView(float min, float max, float stepSize, boolean vertical, Skin skin) {
        super(min, max, stepSize, vertical, skin);
        setUpBounds();
//        setUpView();

    }

/*    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(),getY(),getWidth(),getHeight());
        batch.draw(progresRectangle, progressRectangleX, progressRectangleY, progressRectangleWidth,
                progressRectangleHeight);
    }

    @Override
    public void act(float delta) {
        progressRectangleWidth = progressRectangleWidthMax * stage.getTimeFromPreviousMonth() /
                stage.getLengthOfMonth();
    }*/

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
        setPosition(Constants.MONTH_PROGRESS_X, Constants.MONTH_PROGRESS_Y);

    }

/*
    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        progresRectangle = new TextureRegion(new Texture(Gdx.files.internal("month_progress_rectangle.png")), 0, 0, 50, 50);

        progressRectangleX = RECTANGLE_X;
        progressRectangleY = RECTANGLE_Y;
        progressRectangleHeight = RECTANGLE_HEIGHT;
        progressRectangleWidthMax = RECTANGLE_WIDTH_MAX;
    }
*/

}
