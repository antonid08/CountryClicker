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
    BitmapFont font;

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
        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
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
        batch.draw(region, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, "kek", getX() + 15, getY() + 30);

    }
}
