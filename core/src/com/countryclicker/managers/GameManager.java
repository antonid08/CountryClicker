package com.countryclicker.managers;


import com.badlogic.gdx.Gdx;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 22.03.2016.
 */
public class GameManager {
    private static GameManager instance;

    private int moneyForMonth = 0;
    private int money = 10;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;


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
        Gdx.app.log("money", money + "");
    }

    public void updateTimeFromPreviousMonth(float delta){
        timeFromPreviousMonth += delta;
    }

    public void setTimeFromPreviousMonth(float value){
        timeFromPreviousMonth = value;
    }

    public float getTimeFromPreviousMonth(){
        return timeFromPreviousMonth;
    }

    public int getLengthOfMonth(){
        return lengthOfMonth;
    }

    public int getMoneyForMonth(){
        return moneyForMonth;
    }

    public int getMoney(){
        return money;
    }

}
