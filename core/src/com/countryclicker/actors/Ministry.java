package com.countryclicker.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.countryclicker.managers.GameManager;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 29.02.2016.
 */
public class Ministry extends Actor {

    private int upgradeCost;
    private int level;

    private int moneyPerMonth;
    private int firstLevelMoneyPerMonth;

    private String name;

    private GameManager gameManager;


    public Ministry(String name, int firstLevelMoneyPerMonth, int upgradeCost) {
        this.name = name;
        this.upgradeCost = upgradeCost;
        this.firstLevelMoneyPerMonth = firstLevelMoneyPerMonth;
        level = 0;

        gameManager = GameManager.getInstance();

        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                onClick();
                return true;
            }
        });

    }


    private void upgrade() {
        level++;

        int oldMoneyPerMonth = moneyPerMonth;

        if (level == 1){
            moneyPerMonth = firstLevelMoneyPerMonth;
        } else {
            moneyPerMonth *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
            upgradeCost *= Constants.COST_OF_UPGRADE_MINISTRY_COEF;
        }

        gameManager.updateMoneyForMonth(moneyPerMonth - oldMoneyPerMonth);
    }

    public void onClick() {
        tryUpgrade();
    }

    private void tryUpgrade() {
        if (gameManager.getMoney() >= upgradeCost) {
            upgrade();
            gameManager.updateMoney(-upgradeCost);
        }
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getFirstLevelMoneyPerMonth() {
        return firstLevelMoneyPerMonth;
    }
}
