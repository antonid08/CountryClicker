package com.countryclicker.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.Ministry;


/**
 * Created by Илья on 06.05.2016.
 */
public class MinistryView extends Table {
    //View Constants
    final float coef = 0.3125f;
    final int INFO_PART_WIDTH = 225;
    final int WIDTH = 850;
    final int HEIGHT = (int) ((WIDTH - INFO_PART_WIDTH) * coef);
    Button mainView;
    Button lvlupButton;


    public MinistryView(/*Ministry ministryInfo*/) {
        //setDebug(true);

        setTouchable(Touchable.enabled);
        //setUpButtons(/*ministryInfo*/);
        setUpBounds();
    }

    public void setUpButtons(Ministry ministryInfo) {
        mainView = new Button(AssetsManager.getInstance().getSkin(), "opened-ministry");

        Label.LabelStyle headerStyle = new Label.LabelStyle(AssetsManager.getInstance().getMinistryHeaderFont(), Color.GOLDENROD);
        Label.LabelStyle descriptionStyle = new Label.LabelStyle(AssetsManager.getInstance().getMinistryDescriptionFont(), Color.GOLDENROD);

        mainView.setTouchable(Touchable.disabled);
        Label header = new Label(ministryInfo.getName(), headerStyle);
        mainView.add(header).left().top().expand().padLeft(50).padTop(10); //Name cell
        //mainView.add(numbers).width(100).center();
        mainView.row();
        Label info = new Label(ministryInfo.getInfo(), descriptionStyle);
        mainView.add(info).right().padRight(10);
        mainView.row();

        Label lvlupCost = new Label("Улучшить: " + ministryInfo.getLvlupCost() +" $", descriptionStyle);
        mainView.add(lvlupCost).right().padRight(10);
        mainView.row();

        Label description = new Label(ministryInfo.getDescription(), descriptionStyle);
        mainView.add(description).left().padLeft(50).padBottom(10); //Description cell

        add(mainView).size(WIDTH, HEIGHT);

        lvlupButton = new Button(AssetsManager.getInstance().getSkin(), "lvlup");

        add(lvlupButton).size(INFO_PART_WIDTH, HEIGHT);
    }

    public void updateInfo(Ministry ministryInfo) {
        ((Label) ((Button) getChildren().get(0)).getChildren().get(1)). //info label
                setText(ministryInfo.getInfo());
        ((Label) ((Button) getChildren().get(0)).getChildren().get(2)). //lvlup cost label
                setText("Улучшить: " + ministryInfo.getLvlupCost() + "$");
    }

    private void setUpBounds() {
        setSize(WIDTH, HEIGHT);
    }

    public Button getLvlUpButton() {
        return lvlupButton;
    }
    public Button getMainView() {
        return mainView;
    }
}
