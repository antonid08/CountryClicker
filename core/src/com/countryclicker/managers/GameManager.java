package com.countryclicker.managers;


import com.badlogic.gdx.Gdx;

/**
 * Created by Илья on 22.03.2016.
 */
public class GameManager {
    private static GameManager instance;

    private int moneyForMonth = 0;
    private int money = 0;

    public static GameManager getInstance(){
        if (instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public void updateMoneyForMonth(int delta){
        moneyForMonth += delta;
    }

    public void updateMoney(int delta){
        money += delta;
        Gdx.app.log("money", money+"");
    }

    public int getMoneyForMonth(){
        return moneyForMonth;
    }

    public int getMoney(){
        return money;
    }

}
