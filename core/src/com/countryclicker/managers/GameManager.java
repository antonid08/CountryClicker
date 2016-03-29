package com.countryclicker.managers;


import com.badlogic.gdx.Gdx;
import com.countryclicker.emuns.GameState;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 22.03.2016.
 */
public class GameManager {
    private static GameManager instance;


    private GameState gameState;

    public static GameManager getInstance(){
        if (instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public GameManager(){
        gameState = GameState.RUNNING;
    }



    public void setGameState(GameState value){
        gameState = value;
    }

    public GameState getGameState(){
        return gameState;
    }
}
