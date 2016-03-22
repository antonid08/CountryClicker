package com.countryclicker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.countryclicker.screens.GameScreen;

public class CountryClicker extends Game {
	@Override
	public void create () {
		Gdx.app.log("CountryClicker", "Game created.");
		setScreen(new GameScreen());
	}
}
