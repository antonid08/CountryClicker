package com.countryclicker.model;

import com.countryclicker.view.GameStage;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 29.02.2016.
 */
public class MonthMinistry extends Ministry {
//Mechanics part
    private float moneyPerMonth;

    private int moneyPerMonthOnFirstLevel;


    public MonthMinistry(String name, int moneyPerMonthOnFirstLevel, int upgradeCost, int numbersOfUpgrades,
                         World world){
        super(name, upgradeCost, numbersOfUpgrades, world);

        this.moneyPerMonthOnFirstLevel = moneyPerMonthOnFirstLevel;


        description = "Adds money every month";

    }

    @Override
    void lvlup() {
        level++;

        calculateMoneyPerMonth();

        lvlupCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    private void calculateMoneyPerMonth(){
        float oldMoneyPerMonth = moneyPerMonth;

        moneyPerMonth = level * moneyPerMonthOnFirstLevel * upgradeCoefficient;
        world.updateMoneyForMonth((int) (moneyPerMonth - oldMoneyPerMonth));
    }

    public int getFirstLevelMoneyPerMonth() {
        return moneyPerMonthOnFirstLevel;
    }


    @Override
    public void updateCoefficient(float value) {
        super.updateCoefficient(value);
        calculateMoneyPerMonth();
    }
}