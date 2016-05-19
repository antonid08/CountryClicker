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

        moneyPerMonth = 0;

        description = "Приносит деньги в казну каждый месяц.";
        info = moneyPerMonth + "$/месяц";
    }

    @Override
    public void reset(){
        super.reset();
        level = 0;
        world.updateMoneyForMonth(-(int)moneyPerMonth);
        moneyPerMonth = 0;
        calculateMoneyPerMonth();
      /*  float patriotsCoef = world.getPatriots() / 100 * Constants.PERCENT_FOR_PATRIOT;
        moneyPerMonth = moneyPerMonthOnFirstLevel * upgradeCoefficient;
        moneyPerMonth += moneyPerMonth * patriotsCoef;
        info = moneyPerMonth + "$/месяц";*/
    }

    @Override
    void lvlup() {
        level++;

        calculateMoneyPerMonth();
        lvlupCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    private void calculateMoneyPerMonth() {
        float oldMoneyPerMonth = moneyPerMonth;
        float patriotsCoef = world.getPatriots() / 100 * Constants.PERCENT_FOR_PATRIOT;

        moneyPerMonth = level * moneyPerMonthOnFirstLevel * upgradeCoefficient;
        moneyPerMonth += moneyPerMonth * patriotsCoef;
        world.updateMoneyForMonth((int) (moneyPerMonth - oldMoneyPerMonth));
        info = moneyPerMonth + "$/месяц";
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
