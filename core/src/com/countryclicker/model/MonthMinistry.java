package com.countryclicker.model;

import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 29.02.2016.
 */
public class MonthMinistry extends Ministry {
    //Mechanics part
    private float moneyPerMonth;

    private int moneyPerMonthOnFirstLevel;


    public MonthMinistry(String name, int moneyPerMonthOnFirstLevel, int upgradeCost, int numbersOfUpgrades,
                         World world) {
        super(name, upgradeCost, numbersOfUpgrades, world);

        this.moneyPerMonthOnFirstLevel = moneyPerMonthOnFirstLevel;

        description = "Приносит деньги в казну каждый месяц.";
        info = moneyPerMonthOnFirstLevel + "$/месяц";
    }

    @Override
    public void reset(){
        super.reset();
        float patriotsCoef = world.getPatriots() / 100 * Constants.PERCENT_FOR_PATRIOT;
        moneyPerMonth = moneyPerMonthOnFirstLevel * patriotsCoef;
    }

    @Override
    void lvlup() {
        level++;

        calculateMoneyPerMonth();

        info = moneyPerMonth + "$/месяц";
        lvlupCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    private void calculateMoneyPerMonth() {
        float oldMoneyPerMonth = moneyPerMonth;
        float patriotsCoef = world.getPatriots() / 100 * Constants.PERCENT_FOR_PATRIOT;

        moneyPerMonth = level * moneyPerMonthOnFirstLevel * upgradeCoefficient;
        moneyPerMonth += moneyPerMonth * patriotsCoef;
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
