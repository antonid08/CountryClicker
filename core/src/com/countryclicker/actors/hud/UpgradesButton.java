package com.countryclicker.actors.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.countryclicker.emuns.GameState;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

import java.io.Serializable;

/**
 * Created by Илья on 27.03.2016.
 */
public class UpgradesButton extends TextButton implements Serializable{
    private final int HEIGHT = 50;
    private final int WIDTH = 200;
    private final int X = 20;
    private final int Y = 400;

    private GameManager gameManager;
    private AssetsManager assetsManager;

    public UpgradesButton(String text, TextButtonStyle style) {
        super(text, style);
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
