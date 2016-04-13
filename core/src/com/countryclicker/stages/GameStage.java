package com.countryclicker.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.actors.hud.UpgradesButton;
import com.countryclicker.actors.ministries.ClickMinistry;
import com.countryclicker.actors.Human;
import com.countryclicker.actors.ministries.MonthMinistry;
import com.countryclicker.actors.hud.Money;
import com.countryclicker.actors.hud.MonthProgress;
import com.countryclicker.actors.upgrades.Upgrade;
import com.countryclicker.actors.upgrades.Upgrades;
import com.countryclicker.utils.Constants;

import java.io.Serializable;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage implements Serializable {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private int moneyForMonth = 0;
    private int moneyPerClick = 1;
    private int money = 100000;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;


    private  Money moneyLabel;
    private  MonthProgress monthProgress;

    private transient UpgradesButton upgradesButton;

    private transient Human human;

    private transient MonthMinistry[] ministries;
    private transient ClickMinistry clickMinistry;

    private transient Upgrades upgrades;

    private transient ScrollPane scroller;
    private transient Table ministriesTable;

    public GameStage(){
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        seUpMinistries();
        setUpScroller();

        setUpMoney();
        setUpMonthProgress();

        setUpHuman();

        setUpUpgrades();
        setUpUpgradesButton();
    }


    private void seUpMinistries() {
        clickMinistry = new ClickMinistry(Constants.NAMES_OF_MINISTRIES[0], Constants.FIRST_MINISTRY_MONEY_FOR_CLICK,
                Constants.COSTS_OF_MINISTRIES[0], this);

        ministries = new MonthMinistry[7];

        ministries[0] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[1], Constants.FIRST_MINISTRY_MONEY_PER_FIRST_MONTH,
                Constants.COSTS_OF_MINISTRIES[1], this);

        for (int i = 1; i < ministries.length - 1; i++){
            ministries[i] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[i + 1], ministries[i - 1].getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF, Constants.COSTS_OF_MINISTRIES[i + 1], this);
        }


    }

    public void setUpScroller(){
        ministriesTable = new Table();

        ministriesTable.add(clickMinistry);
        ministriesTable.row().pad(15);

        for (int i = 0; i <ministries.length; i++){
            ministriesTable.add(ministries[i]);
            ministriesTable.row().pad(15);
        }


        scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        Table table = new Table();
        table.add(scroller).padTop(90).padLeft(180);
        table.setFillParent(true);

        addActor(table);
    }

    private void setUpHuman(){
        human = new Human(this);
        addActor(human);
    }

    private void setUpMoney(){
        moneyLabel = new Money(this);
        addActor(moneyLabel);
    }

    private void setUpMonthProgress() {
        monthProgress = new MonthProgress(this);
        addActor(monthProgress);
    }

    private void setUpUpgradesButton(){
        upgradesButton = new UpgradesButton("Upgrades");
        addActor(upgradesButton);
    }

    private void setUpUpgrades(){
        upgrades = new Upgrades(this);
        addActor(upgrades);

        clickMinistry.registerObserverToUpgrade(0);
        ministries[0].registerObserverToUpgrade(1);
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

    public void setMoneyPerClick(int value){
        moneyPerClick = value;
    }

    public int getMoneyPerClick()
    {
        return moneyPerClick;
    }

    public Upgrade getUpgrade(int number){
        return upgrades.getUpgrades().get(number);
    }
}
