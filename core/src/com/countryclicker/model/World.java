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
        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[2], ((MonthMinistry) ministries.get(1)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF,
                Constants.COSTS_OF_MINISTRIES[2], 2, this));
        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[3], ((MonthMinistry) ministries.get(2)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF,
                Constants.COSTS_OF_MINISTRIES[3], 10, this));
        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[4], ((MonthMinistry) ministries.get(3)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF,
                Constants.COSTS_OF_MINISTRIES[4], 3, this));
        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[5], ((MonthMinistry) ministries.get(4)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF,
                Constants.COSTS_OF_MINISTRIES[5], 10, this));
        ministries.add(new MonthMinistry(Constants.NAMES_OF_MINISTRIES[6], ((MonthMinistry) ministries.get(5)).getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF,
                Constants.COSTS_OF_MINISTRIES[6], 4, this));

    }

    private void setUpUpgrades(){
        upgrades = new ArrayList<Upgrade>();

        upgrades.add(new Upgrade("Стальные дубинки в МВД", "Увеличивает прибыль за удар МВД", 1000, 2, this));
        upgrades.add(new Upgrade("Налог на мусор", "Увеличивает месячную прибыль ЖКХ", 5000, 2, this));
        upgrades.add(new Upgrade("Налог на болезни", "Увеличивает месячную прибыль Мин. Здрав.", 15000, 3, this));
        upgrades.add(new Upgrade("Разрешить продажу оружия", "Увеличивает прибыль Мин. Обороны", 30000, 5, this));
        upgrades.add(new Upgrade("Придумывать новые налоги.", "Увеличивает прибыль Мин. Налогов", 60000, 2, this));
    }

    public boolean update(float delta){
        Gdx.app.log("mfm", "Money for month: " + moneyForMonth);
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

    int counter = 0;
    public void humanKicked(){
        money += human.getMoneyForKick(counter++);
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

    public float getTimeFromPreviousMonth(){
        return timeFromPreviousMonth;
    }

    public int getLengthOfMonth(){
        return lengthOfMonth;
    }
}
