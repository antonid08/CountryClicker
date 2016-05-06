package com.countryclicker.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.actors.Background;
import com.countryclicker.actors.hud.MainButton;
import com.countryclicker.actors.hud.MinistriesTable;
import com.countryclicker.actors.Human;
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
    private float money = 100000;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;

    private Background background;

    private Money moneyLabel;
    private MonthProgress monthProgress;

    private transient MainButton mainButton;

    private transient Human human;


    private transient Upgrades upgrades;


    public GameStage(){
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpBackground();


        setUpMoney();
        setUpMonthProgress();

        setUpHuman();

        setUpUpgrades();
        setUpUpgradesButton();

        setUpMinistries();
    }

    private void setUpBackground(){
        background = new Background(this);
        addActor(background);
    }



    public void setUpMinistries(){
        addActor(new MinistriesTable(this));
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
        mainButton = new MainButton("Nalogi", this);
        addActor(mainButton);
    }

    private void setUpUpgrades(){
        upgrades = new Upgrades(this);
        addActor(upgrades);
    }

    public void updateMoneyForMonth(int delta){
        moneyForMonth += delta;
    }

    public void updateMoney(float delta){
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

    public float getMoney(){
        return money;
    }

    public void setMoneyPerClick(int value){
        moneyPerClick = value;
    }

    public int getMoneyPerClick()
    {
        return moneyPerClick;
    }

    public Upgrades getUpgrades(){
        return upgrades;
    }
    public Upgrade getUpgrade(int number){
        return upgrades.getUpgrades().get(number);
    }



}
