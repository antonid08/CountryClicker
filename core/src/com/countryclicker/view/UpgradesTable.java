package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.Upgrade;
import com.countryclicker.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Илья on 07.05.2016.
 */
public class UpgradesTable extends Table {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private ArrayList<UpgradeView> upgradeViews;

    private Table upgradesTable;
    private ScrollPane scroller;


    public UpgradesTable(ArrayList<Upgrade> upgradesInfo) {
        setUpUpgrades(upgradesInfo);
        setUpBounds();
        setUpScroller();
    }

    private void setUpUpgrades(ArrayList<Upgrade> upgradesInfo) {
        upgradeViews = new ArrayList<UpgradeView>();
        for (Upgrade upgradeInfo : upgradesInfo) {
            upgradeViews.add(new UpgradeView(upgradeInfo));
        }
    }

    private void setUpBounds() {
        setBackground(AssetsManager.getInstance().getSkin().getDrawable("button-up"));
        setSize(WIDTH, HEIGHT);
        setPosition((Constants.APP_WIDTH - getWidth()) / 2, (Constants.APP_HEIGHT - getHeight()) / 2);
    }

    private void setUpScroller() {
        //setDebug(true);

        upgradesTable = new Table();

        for (UpgradeView view : upgradeViews) {
            upgradesTable.add(view).size(550, 125).padBottom(20);
            upgradesTable.row();
        }

        scroller = new ScrollPane(upgradesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller).size(550, 470);
        setVisible(false);
    }

    public void removeUpgradeView(int number) {
        try {
            upgradeViews.remove(number);
            clear();
            setUpScroller();
            setVisible(true);
        } catch (IndexOutOfBoundsException e){
            clear();
        }
    }

    /*public ArrayList<Upgrade> getUpgrades(){
        return upgrades;
    }*/

    public UpgradeView getUpgradeView(int number) {
        return upgradeViews.get(number);
    }
}
