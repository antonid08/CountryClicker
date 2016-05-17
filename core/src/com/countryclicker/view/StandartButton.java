package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.managers.AssetsManager;

/**
 * Created by Илья on 06.05.2016.
 */
public class StandartButton extends TextButton {
    private final float coef = 3.94f;
    private final int HEIGHT = 60;
    private final int WIDTH = (int) (HEIGHT * coef);


    public StandartButton(String text, float x, float y) {
        super(text, AssetsManager.getInstance().getSkin());
        setUpBounds(x, y);
    }

    private void setUpBounds(float x, float y) {
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
    }
/*
    private void onClick(){
        gameManager.setGameState(GameState.SHOWING_UPGRADES);
        stage.getUpgrades().setVisible(true);
    }*/
}
