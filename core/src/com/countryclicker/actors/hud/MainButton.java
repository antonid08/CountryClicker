package com.countryclicker.actors.hud;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.emuns.GameState;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;

import java.io.Serializable;

/**
 * Created by Илья on 27.03.2016.
 */
public class MainButton extends TextButton implements Serializable{
    private final float coef = 3.94f;
    private final int HEIGHT = 60;
    private final int WIDTH = (int)(HEIGHT * coef);
    private final int X = 70;
    private final int Y = 350;

    private GameManager gameManager;
    private AssetsManager assetsManager;

    public MainButton(String text) {
        super(text, AssetsManager.getInstance().getSkin());
        assetsManager = AssetsManager.getInstance();

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
        setPosition(X, Y);
    }

    private void onClick(){
        gameManager.setGameState(GameState.SHOWING_UPGRADES);
    }
}
