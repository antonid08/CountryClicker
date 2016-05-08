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


    public HumanView (GameStage stage){

        setPosition(X, Y);
        setSize(WIDTH, HEIGHT);

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                /* call controller;s method onClickHuman */
                return true;
            }
        });

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
        batch.draw(AssetsManager.getInstance().getHumanAnimation().getKeyFrame(0), getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        /* call controller's method humanAct */

        /*if (state == State.KICKED) {
            animationTime += delta;
            if (animationTime > Constants.HUMAN_HIT_ANIMATION_TIME) {
                state = State.NORMAL;
                animationTime = 0;
            }
        }*/
    }

}
