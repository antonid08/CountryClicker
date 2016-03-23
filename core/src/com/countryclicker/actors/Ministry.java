package com.countryclicker.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

import java.awt.Rectangle;

/**
 * Created by Илья on 29.02.2016.
 */
public class Ministry extends Actor {
//Mechanics part
    private int upgradeCost;
    private int level;

    private float moneyPerMonth;
    private int moneyPerMonthOnFirstLevel;

    private String name;

    private GameManager gameManager;

//Drawable part
    TextureRegion region;
    TextureRegion update_icon_region;
    BitmapFont font;

    int infoPartX;
    int infoPartWidth;

    public Ministry(String name, int moneyPerMonthOnFirstLevel, int upgradeCost, int x, int y) {
        this.name = name;
        this.upgradeCost = upgradeCost;
        this.moneyPerMonthOnFirstLevel = moneyPerMonthOnFirstLevel;
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

    private void upgrade() {
        level++;

        float oldMoneyPerMonth = moneyPerMonth;

        if (level == 1){
            moneyPerMonth = moneyPerMonthOnFirstLevel;
            gameManager.updateMoneyForMonth(moneyPerMonthOnFirstLevel);
        } else {
            moneyPerMonth *= Constants.MONEY_PER_MONTH_FOR_NEXT_LEVEL_COEF;
            gameManager.updateMoneyForMonth((int) (moneyPerMonth - oldMoneyPerMonth));
        }
        upgradeCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    public void onClick() {
        tryUpgrade();
    }

    private void tryUpgrade() {
        if (gameManager.getMoney() >= upgradeCost) {
            gameManager.updateMoney(-upgradeCost);
            upgrade();
        }
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getFirstLevelMoneyPerMonth() {
        return moneyPerMonthOnFirstLevel;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if (level == 0) {
            batch.setColor(Color.GRAY);

            //Main part
            batch.draw(region, getX(), getY(), getWidth(), getHeight());
            font.draw(batch, name, getX() + 15, getY() + 30);

            //Info part
            batch.draw(region, infoPartX, getY(), infoPartWidth, getHeight());
            batch.draw(update_icon_region, infoPartX + 10, getY() + 15, 20, 20);
            font.draw(batch, upgradeCost + "$", infoPartX + 60, getY() + 30);

            batch.setColor(1, 1, 1, 1);

            return;
        }
        //Main part
        batch.draw(region, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, name, getX() + 15, getY() + 30);
        font.draw(batch, (int) moneyPerMonth + "$", getX() + 200, getY() + 30);

        //Info part
        batch.draw(region, infoPartX, getY(), infoPartWidth, getHeight());
        batch.draw(update_icon_region, infoPartX + 10, getY() + 15, 20, 20);
        font.draw(batch, upgradeCost + "$", infoPartX + 60, getY() + 30);
        font.draw(batch, "Lvl " + level, infoPartX + 100, getY() + 40);
        batch.setColor(1, 1, 1, 1);
    }
}
