package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;

import org.w3c.dom.Text;

/**
 * Created by Илья on 06.05.2016.
 */
public class UpgradesButton extends TextButton {
    private final float coef = 3.94f;
    private final int HEIGHT = 60;
    private final int WIDTH = (int)(HEIGHT * coef);
    private final int X = 70;
    private final int Y = 350;

    private GameManager gameManager;
    private GameStage stage;

    public UpgradesButton(String text, GameStage stage) {
        super(text, AssetsManager.getInstance().getSkin());

        gameManager = GameManager.getInstance();

        this.stage = stage;



        setUpBounds();
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
        setPosition(X, Y);
    }
/*
    private void onClick(){
        gameManager.setGameState(GameState.SHOWING_UPGRADES);
        stage.getUpgrades().setVisible(true);
    }*/
}
