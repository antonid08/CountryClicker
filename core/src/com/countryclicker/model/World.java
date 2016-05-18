package com.countryclicker.model;

import com.badlogic.gdx.Gdx;
import com.countryclicker.utils.Constants;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Илья on 07.05.2016.
 */

public class World implements Serializable{

    private int moneyForMonth = 0;
    private float money = Constants.START_MONEY;
    private int patriots = 0;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;


    private Human human;
    private ArrayList<Ministry> ministries;
    private ArrayList<Upgrade> upgrades;

    public World() {

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

        for (int i = 2; i < Constants.NUMBER_OF_MINISTRIES; i++) {
            ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[i], ((MonthMinistry) ministries.get(i - 1)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF, Constants.COSTS_OF_MINISTRIES[i],
                    1, this));
        }
    }

    private void setUpUpgrades(){
        upgrades = new ArrayList<Upgrade>();

        upgrades.add(new Upgrade("Стальные дубинки в МВД", "Увеличивает прибыль за удар МВД", 1000, 2, this));
        upgrades.add(new Upgrade("Налог на вынос мусора", "Увеличивает месячную прибыль ЖКХ", 5000, 2, this));
        upgrades.add(new Upgrade("Налог на смерть", "Увеличивает месячную прибыль Мин. Здрав.", 15000, 3, this));
        upgrades.add(new Upgrade("Налог на жизнь", "Увеличивает месячную прибыль Мин. Здрав.", 30000, 5, this));
        upgrades.add(new Upgrade("Раскрыть дело Оборонсервиса", "Увеличивает прибыль Мин. Обороны", 30000, 5, this));
        upgrades.add(new Upgrade("Придумывать новые налоги.", "Увеличивает прибыль Мин. Налогов", 60000, 2, this));
    }

    public boolean update(float delta){
        updateComponents(delta);
        return calculateTimeMonth(delta);
    }

    private void updateComponents(float delta){
        human.update(delta);
        ((ClickMinistry) ministries.get(0)).update(delta);
    }

    private boolean calculateTimeMonth(float delta){
        timeFromPreviousMonth += delta;
        if (timeFromPreviousMonth >= lengthOfMonth){
            timeFromPreviousMonth = 0;
            money += moneyForMonth;
            return true;
        }
        return false;
    }

    public void buyPatriots(){
        patriots += money / 100 * 2; //2% from money
        reset();
    }

    public void reset(){
        money = 0;
        for (Ministry ministry: ministries){
            ministry.reset();
        }

        upgrades.clear();
        setUpUpgrades();
    }

    public void updateMoneyForMonth(int delta) {
        moneyForMonth += delta;
    }

    public void updateMoney(float delta) {
        money += delta;
        Gdx.app.log("money", money + "");
    }

    public void calculateMoneyFromPrevStat(long diffTime){
        long monthes = diffTime / lengthOfMonth;
        money += moneyForMonth * monthes;

        long mvdKicks = (long)(diffTime / ((ClickMinistry) ministries.get(0)).getTimeToKick());
        money += mvdKicks * ((ClickMinistry) ministries.get(0)).getMoneyPerKick();
    }

    public Ministry getMinistry(int index){
        return ministries.get(index);
    }

    public ArrayList<Ministry> getMinistries(){
       return ministries;
    }

    public Upgrade getUpgrade(int index){
        return upgrades.get(index);
    }

    public ArrayList<Upgrade> getUpgrades(){
        return upgrades;
    }

    public float getMoney(){
        return money;
    }

    public Human getHuman(){
        return human;
    }

    public int getPatriots(){
        return patriots;
    }
}
