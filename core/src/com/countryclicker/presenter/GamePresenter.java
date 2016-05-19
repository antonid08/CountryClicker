package com.countryclicker.presenter;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.model.Human;
import com.countryclicker.model.Ministry;
import com.countryclicker.model.World;
import com.countryclicker.view.GameStage;
import com.countryclicker.view.MinistryView;
import com.countryclicker.view.UpgradeView;

/**
 * Created by Илья on 06.05.2016.
 */
public class GamePresenter {
    private World world;
    private GameStage stage;


    public GamePresenter() {
        world = new World();
        stage = new GameStage(world.getMinistries(), world.getUpgrades());

        setUpValuesForViews();
        setUpListeners();
    }

    public GamePresenter(World world, long diffTime){
        this.world = world;
        stage = new GameStage(world.getMinistries(), world.getUpgrades());

        world.calculateMoneyFromPrevStat(diffTime);

        setUpValuesForViews();
        setUpListeners();
    }

    public void update(float delta) {
        world.update(delta);

        updateMoneyLabel((int)world.getMoney());
        updatePatriotsLabel();

        checkIsMinistriesAvailable();

        stage.act(delta);
        stage.draw();
    }

    private void checkIsMinistriesAvailable(){
        for (int counter = 0; counter < world.getMinistries().size(); counter++){
            if (world.getMinistry(counter).canUpgrade()){
                stage.getMinistryView(counter).getLvlUpButton().setTouchable(Touchable.enabled);
                stage.getMinistryView(counter).getLvlUpButton().setColor(1, 1, 1, 1f);
            } else {
                stage.getMinistryView(counter).getLvlUpButton().setTouchable(Touchable.disabled);
                stage.getMinistryView(counter).getLvlUpButton().setColor(1, 1, 1, 0.3f);
            }
        }
    }

    private void updatePatriotsLabel(){
        stage.getPatriotsLabel().setText("Патриоты: " + world.getPatriots());
    }

    private void updateMoneyLabel(float value){
        String toShow = String.format("$ %.2f", value);

        if (value > 1000000 && value < 1000000000){
            toShow = String.format("$ %.2fM", value / 1000000);
        }
        if (value > 1000000000 && value < 1000000000000f){
            toShow = String.format("$ %.2fM", value / 1000000000);
        }

        stage.getMoneyLabel().setText(toShow);
    }

    private void setUpValuesForViews(){
        updateMoneyLabel((int) world.getMoney());
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

        stage.getPatrionsButton().addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                patriotsButtonClicked();
                return true;
            }
        });

        for (int counter = 0; counter < world.getMinistries().size(); counter++) {
            final int numberOfMinistry = counter;
            stage.getMinistryView(counter).getLvlUpButton().addListener(new InputListener() {
                @Override
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    ministryClicked(numberOfMinistry);
                    return true;
                }
            });
        }

        setUpUpgradesListeners();
    }

    private void setUpUpgradesListeners(){
        for (int counter = 0; counter < world.getUpgrades().size(); counter++) {
            final int numberOfUpgrade = counter;
            stage.getUpgradeView(counter).addListener(new InputListener() {
                @Override
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    upgradeClicked(numberOfUpgrade);
                }
            });
        }
    }

    private void upgradeClicked(int number){
        if (world.getUpgrade(number).tryBuy()){
            stage.getUpgradesTable().removeUpgradeView(number);
            updateMinistries();
            world.getUpgrades().remove(number);

            for (UpgradeView view: stage.getUpgradesTable().getUpgradeViews()){
                view.clearListeners();
            }
            setUpUpgradesListeners();
        }
    }

    private void updateMinistries(){
        for (int counter = 0; counter < world.getMinistries().size(); counter++){
            stage.getMinistryView(counter).updateInfo(world.getMinistry(counter));
        }
    }

    private void ministryClicked(int number) {
        world.getMinistry(number).tryLvlUp();
        stage.getMinistryView(number).updateInfo(world.getMinistry(number));
    }

    private void upgradesButtonClicked() {
        stage.getUpgradesTable().setVisible(!stage.getUpgradesTable().isVisible());
    }

    private void patriotsButtonClicked(){
        world.buyPatriots();
        for(int counter = 0; counter < world.getMinistries().size(); counter++){
            stage.getMinistryView(counter).updateInfo(world.getMinistry(counter)); //add number of ministry
        }
    }

    private void humanClicked() {
        world.getHuman().state = Human.State.KICKED;
        world.updateMoney(world.getHuman().getMoneyPerClick());
    }

    public World getWorld(){
        return world;
    }

    public GameStage getStage() {
        return stage;
    }

}
