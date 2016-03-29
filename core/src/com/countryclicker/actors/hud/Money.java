package com.countryclicker.actors.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

import java.awt.Label;

import javafx.scene.text.Font;

/**
 * Created by Илья on 22.03.2016.
 */
public class Money extends Actor {
    private BitmapFont font;

    private GameStage stage;

    public Money(GameStage stage){
        this.stage = stage;

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, "Money: " + stage.getMoney(),
                Constants.MONEY_LABEL_X, Constants.MONEY_LABEL_Y);
    }

    @Override
    public void act(float delta) {
        stage.updateTimeFromPreviousMonth(delta);
        if (stage.getTimeFromPreviousMonth() >= stage.getLengthOfMonth()){
            stage.setTimeFromPreviousMonth(0);
            stage.updateMoney(stage.getMoneyForMonth());
        }
    }

}
