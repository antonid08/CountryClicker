package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
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
        add(upgradeInfo.getName());
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
    }

}
