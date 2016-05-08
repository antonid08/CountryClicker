package com.countryclicker.model;

import com.badlogic.gdx.Gdx;
import com.countryclicker.utils.Constants;
import com.countryclicker.utils.ModelSubscriber;

import java.util.ArrayList;

/**
 * Created by Илья on 07.05.2016.
 */

public class World {

    private int moneyForMonth = 0;
    private float money = 100000;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;

    private ArrayList<ModelSubscriber> subscribers;

    private Human human;
    private ArrayList<Ministry> ministries;
    private ArrayList<Upgrade> upgrades;

    public World() {
        subscribers = new ArrayList<ModelSubscriber>();

        human = new Human(this);
        setUpUpgrades();
        setUpMinistries();
    }

    private void setUpMinistries() {
        ministries = new ArrayList<Ministry>();


        ministries.add(new ClickMinistry(Constants.NAMES_OF_MINISTRIES[0], Constants.FIRST_MINISTRY_MONEY_FOR_CLICK,
                Constants.START_TIME_TO_KICK_MVD,
                Constants.COSTS_OF_MINISTRIES[0], 0, this));


        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[1], Constants.FIRST_MINISTRY_MONEY_PER_FIRST_MONTH,
                Constants.COSTS_OF_MINISTRIES[1], 1, this));

        for (int i = 2; i < Constants.NUMBER_OF_MINISTRIES - 1; i++) {
            ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[i + 1], ((MonthMinistry) ministries.get(i - 1)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF, Constants.COSTS_OF_MINISTRIES[i + 1],
                    1, this));
        }
    }

    private void setUpUpgrades(){
       upgrades = new ArrayList<Upgrade>();

       upgrades.add(new Upgrade("Pizdit silnee", 1000, 3, this));
       upgrades.add(new Upgrade("Vvesti nalog na musor", 2000, 5, this));
    }

    public void update(float delta){
        updateComponents(delta);
        calculateTimeMonth(delta);
        notifySubscribers();
    }

    private void updateComponents(float delta){
        human.update(delta);
        ((ClickMinistry) ministries.get(0)).update(delta);
    }

    private void calculateTimeMonth(float delta){
        timeFromPreviousMonth += delta;
        if (timeFromPreviousMonth >= lengthOfMonth){
            timeFromPreviousMonth = 0;
            money += moneyForMonth;
        }
    }
    private void notifySubscriber(ModelSubscriber subscriber) {
        assert subscriber != null;
        subscriber.modelChanged(this);
    }


    protected void notifySubscribers() {
        for (final ModelSubscriber subscriber : subscribers)
            notifySubscriber(subscriber);
    }

    public void registerObserver(ModelSubscriber subscriber) {
        if (subscriber == null)
            throw new NullPointerException("Empty observer");
        if (subscribers.contains(subscriber))
            throw new IllegalArgumentException("Repeated subscribe: " +
                    subscriber);
        subscribers.add(subscriber);
        notifySubscriber(subscriber);
    }

    public void removeObserver(ModelSubscriber subscriber) {
        if (subscriber == null)
            throw new NullPointerException("Empty subscriber");
        if (!subscribers.contains(subscriber))
            throw new IllegalArgumentException("Try to remove unknown subscriber : " +
                    subscriber);
        subscribers.remove(subscriber);
    }


    public void updateMoneyForMonth(int delta) {
        moneyForMonth += delta;
    }

    public void updateMoney(float delta) {
        money += delta;
        Gdx.app.log("money", money + "");
    }

    public Ministry getMinistry(int index){
        return ministries.get(index);
    }

    public Upgrade getUpgrade(int index){
        return upgrades.get(index);
    }

    public float getMoney() {
        return money;
    }

    public Human getHuman(){
        return human;
    }


}
