package com.countryclicker.model;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.view.GameStage;
import com.countryclicker.utils.Observable;
import com.countryclicker.utils.Observer;

import java.util.ArrayList;

/**
 * Created by Илья on 27.03.2016.
 */
public class Upgrade extends Button implements Observable{
    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    GameStage stage;

    private ArrayList<Observer> obserservingMinistries;

    private String name;
    private float coefficient;
    private float timeEllapsingCoefficient;
    private float cost;
    private boolean isBought;


    public Upgrade(String name, float cost, float coefficient, GameStage stage){
        super(AssetsManager.getInstance().getSkin());
        this.name = name;
        this.cost = cost;
        this.coefficient = coefficient;

        isBought = false;

        this.stage = stage;

        obserservingMinistries = new ArrayList<Observer>();

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

       // setUpBounds();
    }

    private void setUpBounds(){
        setSize(10, 10);
    }

    private void onClick(){
        if (canBuy()){
            buy();
        }
    }

    private void buy(){
        stage.updateMoney((int) -cost);
        isBought = true;
        notifyObservers();
        setVisible(false);
    }

    private boolean canBuy(){
        return stage.getMoney() >= cost;
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
