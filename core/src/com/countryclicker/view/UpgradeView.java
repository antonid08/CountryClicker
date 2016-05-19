package com.countryclicker.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.Upgrade;


/**
 * Created by Илья on 07.05.2016.
 */
public class UpgradeView extends Button {
    private final int WIDTH = 550;
    private final int HEIGHT = 125;


    public UpgradeView(Upgrade upgradeInfo){
        super(AssetsManager.getInstance().getSkin());

        setUpView(upgradeInfo);
        setUpBounds();
    }


    private void setUpView(Upgrade upgradeInfo){
        Label.LabelStyle headerStyle = new Label.LabelStyle(AssetsManager.getInstance().getUpgradeHeaderFont(),
                Color.GOLDENROD);
        Label header = new Label(upgradeInfo.getName(), headerStyle);
        add(header).top().padTop(20).colspan(2);
        row();
        Label.LabelStyle descriptionStyle = new Label.LabelStyle(AssetsManager.getInstance().getUpgradeDescriptionFont(),
                Color.GOLD);
        Label description = new Label(upgradeInfo.getDescription(), descriptionStyle);
        add(description).expand().colspan(2);

        row();
        Label.LabelStyle infoStyle = new Label.LabelStyle((AssetsManager.getInstance().getUpgradeHeaderFont()),
                Color.GOLDENROD);
        Label cost = new Label("$ " + upgradeInfo.getCost(), infoStyle);
        add(cost).padBottom(10);
        Label info = new Label(upgradeInfo.getInfo(), infoStyle);
        add(info).padBottom(10);
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
    }

}
