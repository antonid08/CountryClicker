package com.countryclicker.actors.ministries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
abstract class Ministry extends Actor{
//View Constants
    final int WIDTH = 750;
    final int HEIGHT = 80;
    final int MAIN_PART_WIDTH = 550;
    final int DISTANCE_BETWEEN_MAIN_AND_INFO_PART = 50;
    final int INFO_PART_WIDTH = 150;
    final int INFO_PART_X = (int) getX() + MAIN_PART_WIDTH  + DISTANCE_BETWEEN_MAIN_AND_INFO_PART;

//Mechanics part
    int upgradeCost;
    int level;

    String name;
    String description;

    GameStage stage;

//Drawable part
    TextureRegion region;
    TextureRegion update_icon_region;
    BitmapFont font;

    public Ministry(String name, int upgradeCost, GameStage stage) {
        this.name = name;
        this.upgradeCost = upgradeCost;
        level = 0;

        this.stage = stage;

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

        setUpBounds();
        setUpView();
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
    }

    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        update_icon_region = new TextureRegion(new Texture(Gdx.files.internal("upgrade_icon.png")), 0, 0, 50, 50);

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
    }


    public void onClick() {
        if (canUpgrade()){
            stage.updateMoney(-upgradeCost);
            upgrade();
        }
    }

    boolean canUpgrade(){
        return stage.getMoney() >= upgradeCost;
    }

    abstract void upgrade();

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Main part
        if (level == 0) {
            batch.setColor(Color.GRAY);
        }
        batch.draw(region, getX(), getY(), MAIN_PART_WIDTH, getHeight());
        font.draw(batch, name, getX() + 20, getY() + 60);
        font.draw(batch, description, getX() + 20, getY() + 30);

        batch.setColor(1, 1, 1, 1);

        //Info part
        if (!canUpgrade()){
            batch.setColor(Color.GRAY);
        }

        batch.draw(region, INFO_PART_X, getY(), INFO_PART_WIDTH, getHeight());
        batch.draw(update_icon_region, INFO_PART_X + 10, getY() + 15, 20, 20);
        font.draw(batch, upgradeCost + "$", INFO_PART_X + 60, getY() + 30);
        font.draw(batch, "Level: " + level, INFO_PART_X + 80, getY() + 60);

        batch.setColor(1, 1, 1, 1);
    }
}
