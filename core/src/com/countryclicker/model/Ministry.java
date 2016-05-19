package com.countryclicker.model;

import com.countryclicker.utils.Observer;

import java.io.Serializable;

/**
 * Created by Илья on 23.03.2016.
 */
public abstract class Ministry implements Observer, Serializable {

    protected int lvlupCost;
    protected int level;

    protected float upgradeCoefficient; //if we buy upgrades, we increment upgrade coefficient and mult profit on this coef

    private int lvlupCostOnFirstLvl;

    String name;
    String description;
    String info;

    World world;

    public Ministry(String name, int lvlupCost, int numbersOfUpgrades, World world) {
        this.world = world;
        this.name = name;
        this.lvlupCost = lvlupCost;
        this.lvlupCostOnFirstLvl = lvlupCost;
        level = 0;
        upgradeCoefficient = 1;

        registerObserverToUpgrade(numbersOfUpgrades);
    }


    public void tryLvlUp() {
        if (canUpgrade()){
            world.updateMoney(-lvlupCost);
            lvlup();
        }
    }

    public boolean canUpgrade() {
        return world.getMoney() >= lvlupCost;
    }

    abstract void lvlup();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLvlupCost() {
        return lvlupCost;
    }

    @Override
    public void updateCoefficient(float value) {
        upgradeCoefficient *= value;
    }

    protected void registerObserverToUpgrade(int number) {
        world.getUpgrade(number).registerObserver(this);
    }

    public void reset(){
        level = 0;
        upgradeCoefficient = 1;
        lvlupCost = lvlupCostOnFirstLvl;
    }

    public String getInfo(){
        return info;
    }
}
