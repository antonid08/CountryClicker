package com.countryclicker.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.utils.Constants;

import java.io.Serializable;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage implements Serializable {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

/*
    private int moneyForMonth = 0;
    private int moneyPerClick = 1;
    private float money = 100000;

    private int lengthOfMonth = Constants.START_LENGTH_OF_MONTH;
    private float timeFromPreviousMonth = 0;
*/

    private Background background;

    private MoneyLabel moneyLabel;
    private MonthView monthProgress;
    private MinistriesTable ministriesTable;
    private UpgradesTable upgradesTable;
    private  UpgradesButton upgradesButton;

    private  HumanView humanView;




    public GameStage(){
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        background = new Background(this);
        ministriesTable = new MinistriesTable(this);
        upgradesButton = new UpgradesButton("Upgrades", this);
        upgradesTable = new UpgradesTable(this);
        monthProgress = new MonthView(0, 10, 1, false, AssetsManager.getInstance().getSkin());
        humanView = new HumanView(this);
        moneyLabel = new MoneyLabel();

        addActor(background);
        addActor(ministriesTable);
        addActor(upgradesButton);
        addActor(upgradesTable);
        addActor(monthProgress);
        addActor(humanView);
        addActor(moneyLabel);
    }


}
