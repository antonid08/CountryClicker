package com.countryclicker.actors.upgrades;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.emuns.GameState;
import com.countryclicker.managers.GameManager;


/**
 * Created by Илья on 27.03.2016.
 */
public class Upgrades extends Table{

    Upgrade mvdUpgrade;
    Upgrade midUpgrade;

    GameManager gameManager;

    TextureRegion region;

    public Upgrades() {
        gameManager = GameManager.getInstance();

        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);

        setUpUpgrades();
        setUpScroller();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (gameManager.getGameState() != GameState.SHOWING_UPGRADES){
            return;
        }

        batch.draw(region, 30, 50, 100, 100);
        super.draw(batch, parentAlpha);
    }

    private void setUpUpgrades(){
        mvdUpgrade = new Upgrade("Pizdit silnee", 10000, 3);
        midUpgrade = new Upgrade("kek", 1000, 5);
    }

    private void setUpScroller(){
        Table upgradesTable = new Table();

        upgradesTable.add(mvdUpgrade);
        upgradesTable.row().pad(15);

        upgradesTable.add(midUpgrade);
        upgradesTable.row().pad(15);

        ScrollPane scroller = new ScrollPane(upgradesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller);
        setFillParent(true);
    }
}
