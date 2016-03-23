package com.countryclicker.actors.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

import java.awt.Label;

import javafx.scene.text.Font;

/**
 * Created by Илья on 22.03.2016.
 */
public class Money extends Actor {

    private GameManager gameManager;

    private BitmapFont font;

    public Money(){
        gameManager = GameManager.getInstance();

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, "Money: " + gameManager.getMoney(),
                Constants.MONEY_LABEL_X, Constants.MONEY_LABEL_Y);
    }

    @Override
    public void act(float delta) {
        gameManager.updateTimeFromPreviousMonth(delta);
        if (gameManager.getTimeFromPreviousMonth() >= gameManager.getLengthOfMonth()){
            gameManager.setTimeFromPreviousMonth(0);
            gameManager.updateMoney(gameManager.getMoneyForMonth());
        }
    }

}
