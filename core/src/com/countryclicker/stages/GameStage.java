package com.countryclicker.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.actors.Human;
import com.countryclicker.actors.Ministry;
import com.countryclicker.actors.hud.Money;
import com.countryclicker.utils.Constants;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private Money money;

    private Human human;

    private Ministry[] ministries;

    public GameStage(){
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        setUpMoney();
        setUpHuman();
        seUpMinistries();
    }

    private void seUpMinistries() {
        ministries = new Ministry[6];

        String[] names = {"Министерство воздуха", "Министерство налогов",
        "Министерство контроля за налогами", "Министерство земли", "Министерство воды",
        "Министерство зла"};

        //here we create first ministry with const parameters, then create 5 more and configure their params like "previous min value * coef"
        ministries[0] = new Ministry(names[0],  Constants.FIRST_MINISTRY_MONEY_PER_FIRST_MONTH, Constants.FIRST_MINISTRY_COST,
                Constants.FIRST_MINISTRY_X, Constants.FIRST_MINISTRY_Y);
        addActor(ministries[0]);

        for (int i = 1; i < ministries.length; i++){
            ministries[i] = new Ministry(names[i], ministries[i - 1].getFirstLevelMoneyPerMonth() *
                    (int) Constants.MONEY_PER_MONTH_FOR_NEXT_MINISTRY_COEF, ministries[i-1].getUpgradeCost()
                    * (int) Constants.COST_OF_NEXT_MINISTRY_COEF, Constants.FIRST_MINISTRY_X,
                    Constants.FIRST_MINISTRY_Y - i * Constants.MINISTRY_HEIGHT - Constants.DISTANCE_BETWEEN_MINISTRIES * i);
            addActor(ministries[i]);
        }

    }

    private void setUpHuman(){
        human = new Human();
        addActor(human);
    }

    private void setUpMoney(){
        money = new Money();
        addActor(money);
    }
}
