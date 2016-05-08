package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.model.ClickMinistry;
import com.countryclicker.model.MonthMinistry;


/**
 * Created by Илья on 04.05.2016.
 */
public class MinistriesTable extends Table{
    private static final float X = 000;
    private static final float Y = 00;


    private transient MonthMinistry[] ministries;
    private transient ClickMinistry clickMinistry;

    GameStage stage;

    public MinistriesTable(GameStage stage){
        setDebug(true);
        setUpBounds();

        this.stage = stage;

        //TODO in table create view for each ministry

     /*   setUpMinistries();

        Table ministriesTable = new Table();
        ministriesTable.add(clickMinistry);
        ministriesTable.row().pad(15);

        for (int i = 0; i < ministries.length; i++){
            ministriesTable.add(ministries[i]);
            ministriesTable.row().pad(15);
        }


        ScrollPane scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller).padTop(90).padLeft(300);
        setFillParent(true);*/
    }


/*     private void setUpMinistries() {
        clickMinistry = new ClickMinistry(Constants.NAMES_OF_MINISTRIES[0], Constants.FIRST_MINISTRY_MONEY_FOR_CLICK,
                Constants.START_TIME_TO_KICK_MVD,
                Constants.COSTS_OF_MINISTRIES[0], 0, stage);

        ministries = new MonthMinistry[7];

        ministries[0] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[1], Constants.FIRST_MINISTRY_MONEY_PER_FIRST_MONTH,
                Constants.COSTS_OF_MINISTRIES[1], 1, stage);

        for (int i = 1; i < ministries.length - 1; i++){
            ministries[i] = new MonthMinistry(Constants.NAMES_OF_MINISTRIES[i + 1], ministries[i - 1].getFirstLevelMoneyPerMonth()
                    * (int) Constants.MONEY_PER_MONTH_NEXT_MINISTRY_COEF, Constants.COSTS_OF_MINISTRIES[i + 1],
                    1, stage);
        }
    }*/
    private void setUpBounds(){
        setPosition(X, Y);
    }
}
