package com.countryclicker.actors.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.emuns.GameState;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.stages.GameStage;

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
    private GameStage stage;

    public MainButton(String text, GameStage stage) {
        super(text, AssetsManager.getInstance().getSkin());

        gameManager = GameManager.getInstance();

        this.stage = stage;

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
        stage.getUpgrades().setVisible(true);
    }
}
