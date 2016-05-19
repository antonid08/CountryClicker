package com.countryclicker.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.AssetsManager;

/**
 * Created by Илья on 06.05.2016.
 */
public class MonthView extends Actor {
    private final int WIDTH = 200;
    private final int HEIGHT = 30;
    private final int X = 500;
    private final int Y = 700;

    private int progressWidth = 0;


    public MonthView() {
        setUpBounds();
//        setUpView();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        AssetsManager.getInstance().getSkin().getDrawable("progress_bar_background").draw(batch,
                getX(), getY(), getWidth(), getHeight());
        AssetsManager.getInstance().getSkin().getDrawable("progress_bar_border").draw(batch,
                getX(), getY(), getWidth(), getHeight());
        AssetsManager.getInstance().getSkin().getDrawable("progress_bar_progress").draw(batch,
                getX(), getY(), progressWidth, getHeight());
        /*batch.draw(region, getX(),getY(),getWidth(),getHeight());
        batch.draw(progresRectangle, progressRectangleX, progressRectangleY, progressRectangleWidth,
                progressRectangleHeight);*/
    }

/*    @Override
    public void act(float delta) {
        progressRectangleWidth = progressRectangleWidthMax * stage.getTimeFromPreviousMonth() /
                stage.getLengthOfMonth();
    }*/

    private void setUpBounds() {
        setSize(WIDTH, HEIGHT);
        setPosition(X, Y);
    }

    public void setProgressWidth(int value) {
        progressWidth = value;
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
