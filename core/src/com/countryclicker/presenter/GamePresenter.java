package com.countryclicker.presenter;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.countryclicker.model.Human;
import com.countryclicker.model.World;
import com.countryclicker.view.GameStage;

import javafx.stage.Screen;

/**
 * Created by Илья on 06.05.2016.
 */
public class GamePresenter {
    private World world;
    private GameStage stage;


    public GamePresenter() {
        world = new World();
        stage = new GameStage(world.getMinistries());

        setUpListeners();
    }

    public void update(float delta) {
        world.update(delta);

        stage.act(delta);
        stage.draw();
    }

    private void setUpListeners(){
        stage.getHumanView().addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                humanClicked();
                return true;
            }
        });
    }

    public void humanClicked() {
        world.getHuman().state = Human.State.KICKED;
        world.updateMoney(world.getHuman().getMoneyPerClick());
    }

    public GameStage getStage(){
        return stage;
    }
    public World getWorld() {
        return world;
    }
}
