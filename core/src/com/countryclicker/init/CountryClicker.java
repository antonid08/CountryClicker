package com.countryclicker.init;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.countryclicker.controller.GameController;
import com.countryclicker.model.World;
import com.countryclicker.view.GameScreen;
import com.countryclicker.view.GameStage;

public class CountryClicker extends Game {
    private World world;
    private GameStage stage;
    private GameController controller;

    @Override
    public void create() {
        world = new World();
        controller = new GameController(world);
        stage = new GameStage(controller);

        setScreen(new GameScreen(stage));
        Gdx.app.log("CountryClicker", "Game created.");
    }
}
