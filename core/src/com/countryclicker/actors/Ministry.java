package com.countryclicker.actors;

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
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
abstract class Ministry extends Actor{
//Mechanics part
    int upgradeCost;
    int level;

    String name;
    String description;

    GameManager gameManager;

//Drawable part
    TextureRegion region;
    TextureRegion update_icon_region;
    BitmapFont font;

    int infoPartX;
    int infoPartWidth;



    public Ministry(String name, int upgradeCost, int x, int y) {
        this.name = name;
        this.upgradeCost = upgradeCost;
        level = 0;

        gameManager = GameManager.getInstance();

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

        setUpBounds(x, y);
        setUpView();
    }

    private void setUpBounds(int x, int y){
        setPosition(x, y);
        setSize(Constants.MINISTRY_WIDTH, Constants.MINISTRY_HEIGHT);
    }

    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        update_icon_region = new TextureRegion(new Texture(Gdx.files.internal("upgrade_icon.png")), 0, 0, 50, 50);

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);

        infoPartWidth = Constants.INFO_MINISTRY_PART_WIDTH;
        infoPartX = Constants.INFO_MINISTRY_PART_X;
    }


    public void onClick() {
        if (canUpgrade()){
            gameManager.updateMoney(-upgradeCost);
            upgrade();
        }
    }

    boolean canUpgrade(){
        return gameManager.getMoney() >= upgradeCost;
    }

    abstract void upgrade();

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Main part
        if (level == 0) {
            batch.setColor(Color.GRAY);
        }
        batch.draw(region, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, name, getX() + 20, getY() + 60);
        font.draw(batch, description, getX() + 20, getY() + 30);

        batch.setColor(1, 1, 1, 1);

        //Info part
        if (!canUpgrade()){
            batch.setColor(Color.GRAY);
        }

        batch.draw(region, infoPartX, getY(), infoPartWidth, getHeight());
        batch.draw(update_icon_region, infoPartX + 10, getY() + 15, 20, 20);
        font.draw(batch, upgradeCost + "$", infoPartX + 60, getY() + 30);

        batch.setColor(1, 1, 1, 1);
    }
}
