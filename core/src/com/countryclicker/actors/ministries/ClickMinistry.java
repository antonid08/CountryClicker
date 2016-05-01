package com.countryclicker.actors.ministries;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
public class ClickMinistry extends Ministry {

    private float moneyPerKick;
    private final int moneyPerKickOnFirstLevel;
    private float timeToKick;
    private float timeFromPrevKick;

    public ClickMinistry(String name, int moneyPerKickOnFirstLevel, float timeToKick,
                         int lvlupCost, GameStage stage) {
        super(name, lvlupCost, stage);

        this.timeToKick = timeToKick;
        this.moneyPerKickOnFirstLevel = moneyPerKickOnFirstLevel;
        moneyPerKick = 1;
        timeFromPrevKick = 0;

        description = "Increment you money per click";
    }

    @Override
    void lvlup() {
        level++;

        calculateTimeToKick();
        lvlupCost *= Constants.COST_OF_UPGRADE_MVD_MINISTRY_COEF;
    }

    private void calculateTimeToKick() {
        timeToKick = Constants.START_TIME_TO_KICK_MVD / level;
        stage.setMoneyPerClick((int) moneyPerKick);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (level != 0) {
            font.draw(batch, (int) moneyPerKick + "$", getX() + 500, getY() + 60);
        }

    }

    @Override
    public void act(float delta) {
        timeFromPrevKick += delta;
        if (timeFromPrevKick > timeToKick){
            timeFromPrevKick = 0;
            stage.updateMoney(moneyPerKick);
        }
    }

    @Override
    public void updateCoefficient(float value) {
        super.updateCoefficient(value);
        moneyPerKick = upgradeCoefficient;
    }
}
