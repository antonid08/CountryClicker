package com.countryclicker.actors.ministries;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.actors.upgrades.Upgrade;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 29.02.2016.
 */
public class MonthMinistry extends Ministry {
//Mechanics part
    private float moneyPerMonth;

    private int moneyPerMonthOnFirstLevel;


    public MonthMinistry(String name, int moneyPerMonthOnFirstLevel, int upgradeCost, GameStage stage){
        super(name, upgradeCost, stage);


        this.moneyPerMonthOnFirstLevel = moneyPerMonthOnFirstLevel;


        description = "Adds money every month";
    }

    @Override
    void upgrade() {
        level++;

        calculateMoneyPerMonth();

        upgradeCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    private void calculateMoneyPerMonth(){
        float oldMoneyPerMonth = moneyPerMonth;

        moneyPerMonth = level * moneyPerMonthOnFirstLevel * upgradeCoefficient;
        stage.updateMoneyForMonth((int) (moneyPerMonth - oldMoneyPerMonth));
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

    @Override
    public void updateCoefficient(float value) {
        super.updateCoefficient(value);
        calculateMoneyPerMonth();
    }
}
