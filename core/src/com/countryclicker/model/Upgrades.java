package com.countryclicker.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.managers.GameManager;
import com.countryclicker.view.GameStage;
import com.countryclicker.utils.Constants;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Илья on 27.03.2016.
 */
public class Upgrades extends Table implements Serializable{

    private ArrayList<Upgrade> upgrades;

    private GameManager gameManager;

    private TextureRegion region;

    public Upgrades(GameStage stage) {
        gameManager = GameManager.getInstance();

        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);

        setUpUpgrades(stage);
        setUpScroller(stage);
    }

/*    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (gameManager.getGameState() != GameState.SHOWING_UPGRADES){
            return;
        }

        batch.draw(region, 30, 50, 100, 100);
        super.draw(batch, parentAlpha);
    }*/

    private void setUpUpgrades(GameStage stage){
        upgrades = new ArrayList<Upgrade>();

        upgrades.add(new Upgrade("Pizdit silnee", 1000, 3, stage));
        upgrades.add(new Upgrade("Vvesti nalog na musor", 2000, 5, stage));
    }

    private void setUpScroller(GameStage stage){
        Table upgradesTable = new Table();

        upgradesTable.setDebug(true);
        setDebug(true);

        upgradesTable.setFillParent(true);
        upgradesTable.add(upgrades.get(0)).maxHeight(50).maxWidth(100);
        upgradesTable.row().pad(15);

        upgradesTable.add(upgrades.get(1));
        upgradesTable.row().pad(15);
        upgradesTable.add(upgrades.get(1));
        upgradesTable.row().pad(15);
        upgradesTable.add(upgrades.get(1));
        upgradesTable.row().pad(15);
        upgradesTable.add(upgrades.get(1));
        upgradesTable.row().pad(15);
        upgradesTable.add(upgrades.get(1));
        upgradesTable.row().pad(15);

        ScrollPane scroller = new ScrollPane(upgradesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        setBackground(new TextureRegionDrawable(AssetsManager.getInstance().getStandartButton()));
        add(scroller).size(100, 50);
//        setFillParent(true);
        setSize(700, 700);
        setPosition((Constants.APP_WIDTH - getWidth()) / 2, (Constants.APP_HEIGHT - getHeight()) / 2);

        setVisible(false);

       /* Table ministriesTable = new Table();
        ministriesTable.add(stage.getClickMinistry());
        ministriesTable.row().pad(15);

        for (int i = 0; i < stage.getMonthMinistries().length; i++){
            ministriesTable.add(stage.getMonthMinistries()[i]);
            ministriesTable.row().pad(15);
        }


        ScrollPane scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller);
        setFillParent(true);*/
    }

    public ArrayList<Upgrade> getUpgrades(){
        return upgrades;
    }
}
