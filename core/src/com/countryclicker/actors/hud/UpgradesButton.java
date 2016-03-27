package com.countryclicker.actors.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.emuns.GameState;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 27.03.2016.
 */
public class UpgradesButton extends TextButton{
    private int HEIGHT = 50;
    private int WIDTH = 200;

    private GameManager gameManager;

    public UpgradesButton(String text) {
        super(text, AssetsManager.getInstance().getSkin());

        gameManager = GameManager.getInstance();

        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

        setUpBounds();
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
        setPosition(Constants.UPGRADES_BUTTON_X, Constants.UPGRADES_BUTTON_Y);
    }

    private void onClick(){
        gameManager.setGameState(GameState.SHOWING_UPGRADES);
    }
}
