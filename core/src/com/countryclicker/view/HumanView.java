package com.countryclicker.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.managers.AssetsManager;

/**
 * Created by Илья on 06.05.2016.
 */
public class HumanView extends Actor {
    private static final float COEF = 1.22f;
    private static final int HEIGHT = 250;
    private static final int WIDTH = (int)(HEIGHT * COEF);
    private static final int X = 40;
    private static final int Y = 420;

    private final GameStage stage;

    public HumanView (final GameStage stage){
        this.stage = stage;

        setPosition(X, Y);
        setSize(WIDTH, HEIGHT);

        setTouchable(Touchable.enabled);


    }

/*
    public void onClick(){
        state = State.KICKED;
        stage.updateMoney(stage.getMoneyPerClick());
    }
*/

    @Override
    public void draw(Batch batch, float parentAlpha) {
     //  batch.setColor(1, 1, 1, parentAlpha);
       //batch.draw(assetsManager.getHumanAnimation().getKeyFrame(animationTime), getX(), getY(), getWidth(), getHeight());
        batch.draw(AssetsManager.getInstance().getHumanAnimation().
                getKeyFrame(/*stage.getWorld().getHuman().getAnimationTime()*/0),
                getX(), getY(), getWidth(), getHeight());
    }



}
