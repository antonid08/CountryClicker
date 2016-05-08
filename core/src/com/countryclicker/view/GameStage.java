package com.countryclicker.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.controller.GameController;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.World;
import com.countryclicker.utils.Constants;
import com.countryclicker.utils.ModelSubscriber;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage implements ModelSubscriber {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private Background background;

    private MoneyLabel moneyLabel;
    private MonthView monthProgress;
    private MinistriesTable ministriesTable;
    private UpgradesTable upgradesTable;
    private UpgradesButton upgradesButton;

    private HumanView humanView;

    private final GameController controller;
    private World world;

    public GameStage(GameController controller) {
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        this.controller = controller;
        subscribeToModel();

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

    private void subscribeToModel(){
        controller.getWorld().registerObserver(this);
    }

    public GameController getController(){
        return controller;
    }

    public World getWorld(){
        return  world;
    }

    @Override
    public void modelChanged(World world) {
        this.world = world;
        Gdx.app.log("kek", String.valueOf(world.getMoney()));
    }

    @Override
    public void act(float delta) {
        controller.update(delta);
    }
}
