package com.countryclicker.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.view.GameStage;
import com.countryclicker.utils.Constants;
import com.countryclicker.utils.Observer;

import java.io.Serializable;

/**
 * Created by Илья on 23.03.2016.
 */
public abstract class Ministry implements Observer{

//Mechanics part
    protected int lvlupCost;
    protected int level;

    protected float upgradeCoefficient; //if we buy upgrades, we increment upgrade coefficient and mult profit on this coef

    String name;
    String description = "ddsadsadsssssssssssssssssssssssssssssssssss";

    World world;

    public Ministry(String name, int lvlupCost, int numbersOfUpgrades, World world) {
        //setDebug(true);
        this.world = world;
        this.name = name;
        this.lvlupCost = lvlupCost;
        level = 0;
        upgradeCoefficient = 1;

        registerObserverToUpgrade(numbersOfUpgrades);
    }


    //TODO to controller
/*    public void onClick() {
        if (canUpgrade()){
            stage.updateMoney(-lvlupCost);
            lvlup();
        }
    }*/

    boolean canUpgrade(){
        return world.getMoney() >= lvlupCost;
    }

    abstract void lvlup();

    @Override
    public void updateCoefficient(float value) {
        upgradeCoefficient *= value;
    }

    protected void registerObserverToUpgrade(int number){
        world.getUpgrade(number).registerObserver(this);
    }
}
