package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.countryclicker.managers.AssetsManager;


/**
 * Created by Илья on 07.05.2016.
 */
public class UpgradeView extends Button {
    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    GameStage stage;




    public UpgradeView(String name, float cost, float coefficient, GameStage stage){
        super(AssetsManager.getInstance().getSkin());

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                /* call onUpgradeClicked() controller's method */
                return true;
            }
        });

        setUpBounds();
    }

    private void setUpBounds(){
        setSize(10, 10);
    }
}
