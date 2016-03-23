package com.countryclicker.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 29.02.2016.
 */
public class MonthMinistry extends Ministry {
//Mechanics part
    private float moneyPerMonth;

    private final int moneyPerMonthOnFirstLevel;

    public MonthMinistry(String name, int moneyPerMonthOnFirstLevel, int upgradeCost, int x, int y) {
        super(name, upgradeCost, x, y);

        this.moneyPerMonthOnFirstLevel = moneyPerMonthOnFirstLevel;

        description = "Adds money every month";
    }

    @Override
    void upgrade() {
        level++;

        float oldMoneyPerMonth = moneyPerMonth;

        if (level == 1){
            moneyPerMonth = moneyPerMonthOnFirstLevel;
            gameManager.updateMoneyForMonth(moneyPerMonthOnFirstLevel);
        } else {
            moneyPerMonth = level * moneyPerMonthOnFirstLevel;
            gameManager.updateMoneyForMonth((int) (moneyPerMonth - oldMoneyPerMonth));
        }
        upgradeCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getFirstLevelMoneyPerMonth() {
        return moneyPerMonthOnFirstLevel;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (level != 0){
            font.draw(batch, (int) moneyPerMonth + "$", getX() + 500, getY() + 60);
        }

    }
}
