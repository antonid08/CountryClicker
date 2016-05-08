package com.countryclicker.init;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.countryclicker.view.GameScreen;

public class CountryClicker extends Game {

    @Override
    public void create() {

        setScreen(new GameScreen());
        Gdx.app.log("CountryClicker", "Game created.");
    }
}
