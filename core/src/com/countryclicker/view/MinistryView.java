package com.countryclicker.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
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


    public MinistryView(Ministry ministryInfo) {
        //setDebug(true);

        setTouchable(Touchable.enabled);
        setUpButtons(ministryInfo);
        setUpBounds();
    }

    protected void setUpButtons(Ministry ministryInfo) {
        Button.ButtonStyle mainButonStyle = new Button.ButtonStyle();
        //mainButonStyle.up()
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

        add(lvlupButton).size(INFO_PART_WIDTH, HEIGHT);
    }

    public void updateInfo(Ministry ministryInfo) {
        ((Label)((Button) getChildren().get(1)).getChildren().get(0)).
                setText(String.valueOf(ministryInfo.getLvlupCost()));
    }

    private void setUpBounds() {
        setSize(WIDTH, HEIGHT);
    }

    public Button getLvlUpButton(){
        return lvlupButton;
    }
}
