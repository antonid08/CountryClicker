package com.countryclicker.model;

import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
public class ClickMinistry extends Ministry {

    private final int moneyPerKickOnFirstLevel;
    private final float timeToKickOnFirstLevel;

    private float moneyPerKick;
    private float timeToKick;
    private float timeFromPrevKick;

    public ClickMinistry(String name, int moneyPerKickOnFirstLevel, float timeToKickOnFirstLevel,
                         int lvlupCost, int numberOfUpgrades, World world) {
        super(name, lvlupCost, numberOfUpgrades, world);

        this.moneyPerKickOnFirstLevel = moneyPerKickOnFirstLevel;
        this.timeToKickOnFirstLevel = timeToKickOnFirstLevel;

        timeToKick = timeToKickOnFirstLevel;
        moneyPerKick = 0;

        timeFromPrevKick = 0;

        description = "Выбивает деньги из граждан";
        info = moneyPerKick / timeToKick + "$ в сек";
    }

    @Override
    void lvlup() {
        level++;
        if (level == 1) {
            moneyPerKick = moneyPerKickOnFirstLevel;
            float patriotsCoef = world.getPatriots() / 100 * Constants.PERCENT_FOR_PATRIOT;
            moneyPerKick += moneyPerKick * patriotsCoef;
        }

        calculateTimeToKick();
        lvlupCost *= Constants.COST_OF_UPGRADE_MVD_MINISTRY_COEF;
        info = moneyPerKick / timeToKick + "$ в сек";
    }


    private void calculateTimeToKick() {
        timeToKick = Constants.START_TIME_TO_KICK_MVD / level;
    }

    public void update(float delta) {
        timeFromPrevKick += delta;
        if (timeFromPrevKick > timeToKick) {
            timeFromPrevKick = 0;
            world.updateMoney(moneyPerKick);
        }
    }

    @Override
    public void reset() {
        super.reset();
        moneyPerKick = 0;
        timeToKick = timeToKickOnFirstLevel;
        info = moneyPerKick / timeToKick + "$ в сек";
    }

    @Override
    public void updateCoefficient(float value) {
        super.updateCoefficient(value);

        moneyPerKick = moneyPerKickOnFirstLevel * upgradeCoefficient;

        info = moneyPerKick / timeToKick + "$ в сек";
    }

    public float getTimeToKick() {
        return timeToKick;
    }

    public float getMoneyPerKick() {
        return moneyPerKick;
    }
}
