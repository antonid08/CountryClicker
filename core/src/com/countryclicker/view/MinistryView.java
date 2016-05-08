package com.countryclicker.view;

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
import com.countryclicker.model.Ministry;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 06.05.2016.
 */
public class MinistryView extends Table {
    //View Constants
    final int WIDTH = 750;
    final int HEIGHT = 80;
    final int INFO_PART_WIDTH = 150;
    Button mainView;
    Button lvlupButton;
    TextureRegion region;
    TextureRegion update_icon_region;
    BitmapFont font;
    private Ministry dataSource;
    private int numberOfMinistry;

    public MinistryView(Ministry ministryInfo) {
        //setDebug(true);

        setTouchable(Touchable.enabled);
        setUpButtons(ministryInfo);
        setUpBounds();
        setUpView();
    }

    protected void setUpButtons(Ministry ministryInfo) {
        mainView = new Button(AssetsManager.getInstance().getSkin());
        mainView.setTouchable(Touchable.disabled);

        // mainView.setDebug(true);
        mainView.add(ministryInfo.getName()).left().top().expand().padLeft(50).padTop(10); //Name cell
        //mainView.add(numbers).width(100).center();
        mainView.row();
        mainView.add(ministryInfo.getDescription()).left().padLeft(50).padBottom(10); //Description cell


        add(mainView).size(WIDTH, HEIGHT);

        lvlupButton = new Button(AssetsManager.getInstance().getSkin());
        lvlupButton.add(String.valueOf(ministryInfo.getLvlupCost()));
        /*lvlupButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                *//* call controller's onThisButtonClick method *//*
                ;
            }
        });*/

        add(lvlupButton).size(INFO_PART_WIDTH, HEIGHT);
    }

    private void setUpBounds() {
        setSize(WIDTH, HEIGHT);
    }

    private void setUpView() {
        region = new TextureRegion(new Texture(Gdx.files.internal("ministry_background.png")), 0, 0, 50, 50);
        update_icon_region = new TextureRegion(new Texture(Gdx.files.internal("upgrade_icon.png")), 0, 0, 50, 50);

        font = AssetsManager.getInstance().getSkin().getFont(Constants.NAME_OF_MAIN_FONT);
    }


    /*public void onClick() {
        if (canUpgrade()){
            stage.updateMoney(-lvlupCost);
            lvlup();
        }
    }*/

}