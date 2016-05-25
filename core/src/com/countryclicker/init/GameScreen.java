package com.countryclicker.init;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.World;
import com.countryclicker.presenter.GamePresenter;
import com.countryclicker.utils.Constants;
import com.countryclicker.view.GameStage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Created by Илья on 29.02.2016.
 */
public class GameScreen implements Screen {
    private GameStage stage;


    public GameScreen() {
        stage = new GameStage();
        Gdx.app.log("GameScreen", "Attached");

        Gdx.input.setInputProcessor(stage);

        AssetsManager.getInstance().getMainTheme().play();

        Music kek = AssetsManager.getInstance().getMainTheme();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(227, 227, 227, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
        stage.getViewport().update(Constants.APP_WIDTH, Constants.APP_HEIGHT, false);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        saveGame();
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
        Gdx.app.log("GameScreen", "exit");
    }

    private void saveGame(){
        saveTime();
        try {
            File saveFile = new File(Constants.SAVE_FILE_NAME);
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }

            FileOutputStream outputStream = new FileOutputStream(Constants.SAVE_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(stage.getPresenter().getWorld());
            oos.flush();
            oos.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void saveTime(){
        try{
            File saveFile = new File(Constants.TIME_FILE_NAME);
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }

            FileOutputStream outputStream = new FileOutputStream(Constants.TIME_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(System.currentTimeMillis());
            oos.flush();
            oos.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private long loadTime(){
        try {
            File saveFile = new File(Constants.TIME_FILE_NAME);
            if (saveFile.exists()) {
                FileInputStream fis = new FileInputStream(Constants.TIME_FILE_NAME);
                ObjectInputStream oin = new ObjectInputStream(fis);
                return (Long) oin.readObject();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        }
        return 0;
    }



}
