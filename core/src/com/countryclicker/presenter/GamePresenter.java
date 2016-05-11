package com.countryclicker.presenter;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.countryclicker.model.Human;
import com.countryclicker.model.World;
import com.countryclicker.view.GameStage;

/**
 * Created by Илья on 06.05.2016.
 */
public class GamePresenter {
    private World world;
    private GameStage stage;


    public GamePresenter() {
        world = new World();
        stage = new GameStage(world.getMinistries(), world.getUpgrades());

        setUpListeners();
    }

    public void update(float delta) {
        world.update(delta);

        stage.act(delta);
        stage.draw();
    }

    private void setUpListeners() {
        stage.getHumanView().addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                humanClicked();
                return true;
            }
        });

        stage.getUpgradesButton().addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                upgradesButtonClicked();
                return true;
            }
        });

        for (int counter = 0; counter < world.getMinistries().size(); counter++) {
            final int numberOfMinistry = counter;
            stage.getMinistryView(counter).addListener(new InputListener() {
                @Override
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    ministryClicked(numberOfMinistry);
                    return true;
                }
            });
        }

        for (int counter = 0; counter < world.getUpgrades().size(); counter++) {
            final int numberOfUpgrade = counter;
            stage.getUpgradeView(counter).addListener(new InputListener() {
                @Override
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    upgradeClicked(numberOfUpgrade);
                    return true;
                }
            });
        }
    }

    private void upgradeClicked(int number){
        if(world.getUpgrade(number).tryBuy()){
            stage.getUpgradesTable().removeUpgradeView(number);
        }
    }

    private void ministryClicked(int number) {
        world.getMinistry(number).tryLvlUp();
        stage.getMinistryView(number).updateInfo(world.getMinistry(number));
    }

    private void upgradesButtonClicked() {
        stage.getUpgradesTable().setVisible(!stage.getUpgradesTable().isVisible());
    }

    private void humanClicked() {
        world.getHuman().state = Human.State.KICKED;
        world.updateMoney(world.getHuman().getMoneyPerClick());
    }

    public GameStage getStage() {
        return stage;
    }

    public World getWorld() {
        return world;
    }
}
