package com.countryclicker.actors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.GameManager;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 23.03.2016.
 */
public class MonthProgress  extends Actor implements Serializable{
    public static final int WIDTH = 150;
    public static final int HEIGHT = 30;
    public static final int RECTANGLE_BORDER = 3;
    public static final int RECTANGLE_HEIGHT = HEIGHT - RECTANGLE_BORDER * 2;
    public static final int RECTANGLE_WIDTH_MAX = WIDTH - RECTANGLE_BORDER * 2;
    public static final int RECTANGLE_X = Constants.MONTH_PROGRESS_X + RECTANGLE_BORDER;
    public static final int RECTANGLE_Y = Constants.MONTH_PROGRESS_Y + RECTANGLE_BORDER;



    private GameStage stage;

    private TextureRegion region;
    private TextureRegion progresRectangle;

    int progressRectangleWidthMax;
    float progressRectangleWidth;
    float progressRectangleHeight;

    int progressRectangleX;
    int progressRectangleY;



    public MonthProgress(GameStage stage){
        this.stage = stage;

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
        progressRectangleWidth = progressRectangleWidthMax * stage.getTimeFromPreviousMonth() /
                stage.getLengthOfMonth();
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
        setPosition(Constants.MONTH_PROGRESS_X, Constants.MONTH_PROGRESS_Y);

    }

    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        progresRectangle = new TextureRegion(new Texture(Gdx.files.internal("month_progress_rectangle.png")), 0, 0, 50, 50);

        progressRectangleX = RECTANGLE_X;
        progressRectangleY = RECTANGLE_Y;
        progressRectangleHeight = RECTANGLE_HEIGHT;
        progressRectangleWidthMax = RECTANGLE_WIDTH_MAX;
    }


}
