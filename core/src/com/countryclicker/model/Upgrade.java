package com.countryclicker.model;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.utils.Observable;
import com.countryclicker.utils.Observer;
import com.countryclicker.view.GameStage;

import java.util.ArrayList;

/**
 * Created by Илья on 27.03.2016.
 */
public class Upgrade extends Button implements Observable {
    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    private World world;

    private ArrayList<Observer> obserservingMinistries;

    private String name;
    private float coefficient;
    private float timeEllapsingCoefficient;
    private float cost;
    private boolean isBought;


    public Upgrade(String name, float cost, float coefficient, World world) {
        super(AssetsManager.getInstance().getSkin());
        this.name = name;
        this.cost = cost;
        this.coefficient = coefficient;

        isBought = false;

        this.world = world;

        obserservingMinistries = new ArrayList<Observer>();
/*

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });
*/

        // setUpBounds();
    }

    private void setUpBounds() {
        setSize(10, 10);
    }
/*
    private void onClick(){
        if (canBuy()){
            buy();
        }
    }*/

    private void buy() {
        world.updateMoney((int) -cost);
        isBought = true;
        notifyObservers();
        setVisible(false);
    }

    private boolean canBuy() {
        return world.getMoney() >= cost;
    }

    public boolean tryBuy(){
        if (canBuy()) {
            buy();
            return true;
        }
        return false;
    }
/*
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //super.draw(batch, parentAlpha);
        batch.draw(region, getX(), getY());
    }*/

    @Override
    public void registerObserver(Observer o) {
        obserservingMinistries.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        obserservingMinistries.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer ministry : obserservingMinistries) {
            ministry.updateCoefficient(coefficient);
        }
    }
}
