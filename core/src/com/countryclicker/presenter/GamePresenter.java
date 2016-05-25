package com.countryclicker.presenter;

import com.countryclicker.model.Human;
import com.countryclicker.model.World;
import com.countryclicker.utils.Constants;
import com.countryclicker.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Илья on 06.05.2016.
 */
public class GamePresenter {
    private World world;
    private View view;


    public GamePresenter(View view) {
        this.view = view;

        world = loadGame();
        if (world == null) {
            world = new World();
        }

        view.setUpMinistryViews(world.getMinistries());
        view.setUpUpgradeViews(world.getUpgrades());
        //stage = new GameStage(world.getMinistries(), world.getUpgrades());

    }


    private World loadGame() {
        try {
            File saveFile = new File(Constants.SAVE_FILE_NAME);
            if (saveFile.exists()) {
                FileInputStream fis = new FileInputStream(Constants.SAVE_FILE_NAME);
                ObjectInputStream oin = new ObjectInputStream(fis);
                return (World) oin.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(float delta) {
        world.update(delta);

        view.updateMoneyLabel((int) world.getMoney());
        view.updatePatriotsLabel(world.getPatriots());
        updateMonthView();
        checkIsMinistriesAvailable();

        //       stage.act(delta);
        //      stage.draw();
    }


    private void checkIsMinistriesAvailable() {
        for (int counter = 0; counter < world.getMinistries().size(); counter++) {
            if (world.getMinistry(counter).canUpgrade()) {
                view.setLvlupButtonIsAvaliable(counter, true);
            } else {
                view.setLvlupButtonIsAvaliable(counter, false);
            }
        }
    }

    private void updateMonthView() {
        view.setMonthProgressWidth(world.getTimeFromPreviousMonth() /
                world.getLengthOfMonth());
/*        stage.getMonthProgress().setProgressWidth((int) (stage.getMonthProgress().getWidth() * world.getTimeFromPreviousMonth() /
                world.getLengthOfMonth()));*/
    }

    private void updatePatriotsLabel() {
        view.updatePatriotsLabel(world.getPatriots());
/*        stage.getPatriotsLabel().setText("Патриоты: " + world.getPatriots());*/
    }


    public void upgradeClicked(int number) {
        if (world.getUpgrade(number).tryBuy()) {
            //stage.getUpgradesTable().removeUpgradeView(number);
            view.removeUpgradeView(number);
            updateMinistries();
            world.getUpgrades().remove(number);

            /*for (UpgradeView view : stage.getUpgradesTable().getUpgradeViews()) {
                view.clearListeners();
            }
            setUpUpgradesListeners();*/
            view.refreshUpgradesListeners();
        }
    }

    private void updateMinistries() {
        for (int counter = 0; counter < world.getMinistries().size(); counter++) {
            view.updateMinistryView(counter, world.getMinistry(counter));
            //stage.getMinistryView(counter).updateInfo(world.getMinistry(counter));
        }
    }

    public void ministryClicked(int number) {
        world.getMinistry(number).tryLvlUp();
        //   if (world.getMinistry(number).getLevel() == 1){
//            Button.ButtonStyle newStyle = new
        //      stage.getMinistryView(number).getMainView().setStyle(AssetsManager.getInstance().getMinistryButtonStyle());
        //}
        view.updateMinistryView(number, world.getMinistry(number));
//        stage.getMinistryView(number).updateInfo(world.getMinistry(number));
    }

    public void upgradesButtonClicked() {
        view.changeUpgradesTableVisibility();
        //stage.getUpgradesTable().setVisible(!stage.getUpgradesTable().isVisible());
    }

    public void patriotsButtonClicked() {
        world.buyPatriots();
        for (int counter = 0; counter < world.getMinistries().size(); counter++) {
            view.updateMinistryView(counter, world.getMinistry(counter));
            //stage.getMinistryView(counter).updateInfo(world.getMinistry(counter)); //add number of ministry
            //stage.getMinistryView(counter).getMainView().setSkin(AssetsManager.getInstance().getSkin());
        }
    }

    public void humanClicked() {
    /*    world.getHuman().state = Human.State.KICKED;
        world.updateMoney(world.getHuman().getMoneyPerClick());*/
        world.humanKicked();
    }

    public World getWorld() {
        return world;
    }

    /*public GameStage getStage() {
        return stage;
    }*/

}
