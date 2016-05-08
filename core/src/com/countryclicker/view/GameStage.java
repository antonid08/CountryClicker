package com.countryclicker.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.Ministry;
import com.countryclicker.utils.Constants;

import java.util.ArrayList;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private Background background;

    private MoneyLabel moneyLabel;
    private MonthView monthProgress;
    private MinistriesTable ministriesTable;
    private UpgradesTable upgradesTable;
    private UpgradesButton upgradesButton;

    private HumanView humanView;

    public GameStage(ArrayList<Ministry> ministriesInfo) {
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));


        background = new Background(this);
        ministriesTable = new MinistriesTable(ministriesInfo);
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


    public HumanView getHumanView() {
        return humanView;
    }
}
