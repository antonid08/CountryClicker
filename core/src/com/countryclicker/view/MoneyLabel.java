package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.countryclicker.managers.AssetsManager;

/**
 * Created by Илья on 06.05.2016.
 */
public class MoneyLabel extends Label {
    public MoneyLabel() {
        super("kek", AssetsManager.getInstance().getSkin());
    }
}
