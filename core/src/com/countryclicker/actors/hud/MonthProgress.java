package com.countryclicker.actors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
public class MonthProgress  extends Actor{
    GameManager gameManager;

    private TextureRegion region;
    private TextureRegion progresRectangle;

    int progressRectangleWidthMax;
    float progressRectangleWidth;
    float progressRectangleHeight;

    int progressRectangleX;
    int progressRectangleY;


    public MonthProgress(){
        gameManager = GameManager.getInstance();

        setUpBounds();
        setUpView();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(),getY(),getWidth(),getHeight());
        batch.draw(progresRectangle, progressRectangleX, progressRectangleY, progressRectangleWidth,
                progressRectangleHeight);
    }

    @Override
    public void act(float delta) {
        progressRectangleWidth = progressRectangleWidthMax * gameManager.getTimeFromPreviousMonth() /
                gameManager.getLengthOfMonth();
    }

    private void setUpBounds(){
        setSize(Constants.MONTH_PROGRESS_WIDTH, Constants.MONTH_PROGRESS_HEIGHT);
        setPosition(Constants.MONTH_PROGRESS_X, Constants.MONTH_PROGRESS_Y);

    }

    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        progresRectangle = new TextureRegion(new Texture(Gdx.files.internal("month_progress_rectangle.png")), 0, 0, 50, 50);

        progressRectangleX = Constants.MONTH_PROGRESS_RECTANGLE_X;
        progressRectangleY = Constants.MONTH_PROGRESS_RECTANGLE_Y;
        progressRectangleHeight = Constants.MONTH_PROGRESS_RECTANGLE_HEIGHT;
        progressRectangleWidthMax = Constants.MONTH_PROGRESS_RECTANGLE_WIDTH_MAX;
    }


}
