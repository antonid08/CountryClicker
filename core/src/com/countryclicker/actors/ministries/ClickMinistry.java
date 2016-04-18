package com.countryclicker.actors.ministries;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.actors.upgrades.Upgrade;
import com.countryclicker.stages.GameStage;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
public class ClickMinistry extends Ministry{

    private float moneyPerClick;
    private final int moneyPerClickOnFirstLevel;

    public ClickMinistry(String name, int moneyPerClickOnFirstLevel, int upgradeCost, GameStage stage) {
        super(name, upgradeCost, stage);

        this.moneyPerClickOnFirstLevel = moneyPerClickOnFirstLevel;
        moneyPerClick = 0;

        description = "Increment you money per click";
    }

    @Override
    void upgrade() {
        level++;

        calculateMoneyPerClick();
        upgradeCost *= Constants.COST_OF_UPGRADE_MVD_MINISTRY_COEF;
    }

    private void calculateMoneyPerClick(){
        moneyPerClick = level * moneyPerClickOnFirstLevel * upgradeCoefficient;
        stage.setMoneyPerClick((int) moneyPerClick);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (level != 0){
            font.draw(batch, (int) moneyPerClick  + "$", getX() + 500, getY() + 60);
        }

    }

    @Override
    public void updateCoefficient(float value) {
        super.updateCoefficient(value);
        calculateMoneyPerClick();
    }
}
