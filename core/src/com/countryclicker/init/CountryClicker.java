package com.countryclicker.init;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.countryclicker.view.GameScreen;

public class CountryClicker extends Game {
	@Override
	public void create () {
		Gdx.app.log("CountryClicker", "Game created.");
		setScreen(new GameScreen());
	}
}
