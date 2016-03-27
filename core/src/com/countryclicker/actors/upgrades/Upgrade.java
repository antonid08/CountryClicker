package com.countryclicker.actors.upgrades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Илья on 27.03.2016.
 */
public class Upgrade extends Actor{
    private final int WIDTH = 200;
    private final int HEIGHT = 50;

    private String name;
    private float coefficient;
    private float cost;
    private boolean isBought;

    TextureRegion region;

    public Upgrade(String name, float cost, float coefficient){
        this.name = name;
        this.cost = cost;
        this.coefficient = coefficient;

        isBought = false;

        region = new TextureRegion(new Texture(Gdx.files.internal("month_progress_rectangle.png")), 0, 0, WIDTH, HEIGHT);

        setUpBounds();
    }

    private void setUpBounds(){
        setSize(WIDTH, HEIGHT);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        //super.draw(batch, parentAlpha);
        batch.draw(region, getX(), getY());
    }
}
