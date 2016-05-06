package com.countryclicker.actors.ministries;

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
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;
import com.countryclicker.utils.Observer;

import java.io.Serializable;

/**
 * Created by Илья on 23.03.2016.
 */
abstract class Ministry extends Table implements Observer, Serializable{
//View Constants
    final int WIDTH = 750;
    final int HEIGHT = 80;
    final int MAIN_PART_WIDTH = 550;
    final int DISTANCE_BETWEEN_MAIN_AND_INFO_PART = 50;
    final int INFO_PART_WIDTH = 150;
    final int INFO_PART_X = (int) getX() + MAIN_PART_WIDTH  + DISTANCE_BETWEEN_MAIN_AND_INFO_PART;

//Mechanics part
    int lvlupCost;
    int level;

    float upgradeCoefficient; //if we buy upgrades, we increment upgrade coefficient and mult profit on this coef

    String name;
    String description = "ddsadsadsssssssssssssssssssssssssssssssssss";

    GameStage stage;

    Button mainView;
    Button lvlupButton;


//Drawable part
    TextureRegion region;
    TextureRegion update_icon_region;
    BitmapFont font;

    public Ministry(String name, int lvlupCost, int numbersOfUpgrades, GameStage stage) {
        //setDebug(true);
        this.name = name;
        this.lvlupCost = lvlupCost;
        level = 0;
        upgradeCoefficient = 1;

        this.stage = stage;

        setTouchable(Touchable.enabled);

        setUpBounds();
        setUpView();
        registerObserverToUpgrade(numbersOfUpgrades);
    }

    protected void setUpButtons(String numbers){
        mainView = new Button(AssetsManager.getInstance().getSkin());
        mainView.setTouchable(Touchable.disabled);

       // mainView.setDebug(true);
        mainView.add(name).left().top().expand().padLeft(50).padTop(10);
        mainView.add(numbers).width(100).center();
        mainView.row();
        mainView.add(description).left().padLeft(50).padBottom(10);



        add(mainView).size(WIDTH, HEIGHT);

        lvlupButton = new Button(AssetsManager.getInstance().getSkin());
        lvlupButton.add(String.valueOf(lvlupCost));
        lvlupButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick();
            }
        });

        add(lvlupButton).size(INFO_PART_WIDTH, HEIGHT);
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
    }

    private void setUpView(){
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        update_icon_region = new TextureRegion(new Texture(Gdx.files.internal("upgrade_icon.png")), 0, 0, 50, 50);

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
    }


    public void onClick() {
        if (canUpgrade()){
            stage.updateMoney(-lvlupCost);
            lvlup();
        }
    }

    boolean canUpgrade(){
        return stage.getMoney() >= lvlupCost;
    }

    abstract void lvlup();

    @Override
    public void updateCoefficient(float value) {
        upgradeCoefficient *= value;
    }

    protected void registerObserverToUpgrade(int number){
        stage.getUpgrade(number).registerObserver(this);
    }
}
