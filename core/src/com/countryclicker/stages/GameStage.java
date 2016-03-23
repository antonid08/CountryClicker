package com.countryclicker.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.actors.ClickMinistry;
import com.countryclicker.actors.Human;
import com.countryclicker.actors.MonthMinistry;
import com.countryclicker.actors.hud.Money;
import com.countryclicker.actors.hud.MonthProgress;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private Money money;
    private MonthProgress monthProgress;

    private Human human;

    private MonthMinistry[] ministries;
    private ClickMinistry clickMinistry;

    private ScrollPane scroller;
    private Table ministriesTable;

    public GameStage(){
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        seUpMinistries();
        setUpScroller();

        setUpMoney();
        setUpMonthProgress();

        setUpHuman();
    }


    private void seUpMinistries() {
        clickMinistry = new ClickMinistry(Constants.NAMES_OF_MINISTRIES[0], Constants.FIRST_MINISTRY_MONEY_FOR_CLICK,
                Constants.COSTS_OF_MINISTRIES[0]);

 //       addActor(clickMinistry);

        ministries = new MonthMinistry[7];

        ministries[0] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[1], Constants.FIRST_MINISTRY_MONEY_PER_FIRST_MONTH,
                Constants.COSTS_OF_MINISTRIES[1]);
  //      addActor(ministries[0]);

        for (int i = 1; i < ministries.length - 1; i++){
            ministries[i] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[i + 1], ministries[i - 1].getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF, Constants.COSTS_OF_MINISTRIES[i + 1]);
//            addActor(ministries[i]);
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

        ministriesTable.setSize(500, 500);


       // ministriesTable.setDebug(true);

        scroller = new ScrollPane(ministriesTable);

        final Table table = new Table();
        table.setFillParent(true);
        table.add(scroller).width(500).height(500);
        table.setSize(500, 500);

table.setDebug(true);
        addActor(table);
    }

    private void setUpHuman(){
        human = new Human();
        addActor(human);
    }

    private void setUpMoney(){
        money = new Money();
        addActor(money);
    }

    private void setUpMonthProgress() {
        monthProgress = new MonthProgress();
        addActor(monthProgress);
    }

}
