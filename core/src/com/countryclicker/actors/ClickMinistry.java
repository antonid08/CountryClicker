package com.countryclicker.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 23.03.2016.
 */
public class ClickMinistry extends Ministry{

    private float moneyPerClick;
    private final int moneyPerClickOnFirstLevel;

    public ClickMinistry(String name, int moneyPerClickOnFirstLevel, int upgradeCost, int x, int y) {
        super(name, upgradeCost, x, y);

        this.moneyPerClickOnFirstLevel = moneyPerClickOnFirstLevel;
        moneyPerClick = 0;

        description = "Increment you money per click";
    }

    @Override
    void upgrade() {
        level++;

        moneyPerClick = level * moneyPerClickOnFirstLevel;

        gameManager.setMoneyPerClick((int) moneyPerClick);
        upgradeCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (level != 0){
            font.draw(batch, (int) moneyPerClick  + "$", getX() + 500, getY() + 60);
        }

    }
}
