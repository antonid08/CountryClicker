package com.countryclicker.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 29.02.2016.
 */
public class GameScreen implements Screen {

    private GameStage gameStage;

    public GameScreen(GameStage stage) {
        Gdx.app.log("GameScreen", "Attached");
 /*       try {
            File saveFile = new File(Constants.SAVE_FILE_NAME);
            if (saveFile.exists()) {
                FileInputStream fis = new FileInputStream(Constants.SAVE_FILE_NAME);
                ObjectInputStream oin = new ObjectInputStream(fis);
                gameStage = (GameStage) oin.readObject();
            } else {
                gameStage = new GameStage();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        gameStage = stage;
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(227, 227, 227, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
        gameStage.getViewport().update(Constants.APP_WIDTH, Constants.APP_HEIGHT, false);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
/*        try {
            File saveFile = new File(Constants.SAVE_FILE_NAME);
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }

            FileOutputStream outputStream = new FileOutputStream(Constants.SAVE_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(gameStage);
            oos.flush();
            oos.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }*/
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

}
