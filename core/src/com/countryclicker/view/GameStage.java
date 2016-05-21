package com.countryclicker.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.countryclicker.managers.AssetsManager;
import com.countryclicker.model.Ministry;
import com.countryclicker.model.Upgrade;
import com.countryclicker.presenter.GamePresenter;
import com.countryclicker.utils.Constants;

import java.util.ArrayList;


/**
 * Created by Илья on 22.03.2016.
 */
public class GameStage extends Stage implements View {
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private GamePresenter presenter;

    private Background background;

    private Label moneyLabel;
    private Label patriotsLabel;

    private MonthView monthProgress;
    private MinistriesTable ministriesTable;
    private UpgradesTable upgradesTable;

    private StandartButton upgradesButton;
    private StandartButton patrionsButton;

    private HumanView humanView;

    public GameStage() {
        super(new ScalingViewport(Scaling.fit, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        background = new Background(this);
        ministriesTable = new MinistriesTable(/*ministriesInfo*/);
        upgradesButton = new StandartButton("Улучшения", 70, 350);
        patrionsButton = new StandartButton("Рестарт", 70, 270);


        upgradesTable = new UpgradesTable(/*upgradesInfo*/);
        monthProgress = new MonthView();
        humanView = new HumanView(this);


        Label.LabelStyle labelStyle = new Label.LabelStyle(AssetsManager.getInstance().getMinistryDescriptionFont(), Color.GOLDENROD);
        moneyLabel = new Label("", labelStyle);
        moneyLabel.setPosition(40, 730);
        patriotsLabel = new Label("", labelStyle);
        patriotsLabel.setPosition(40, 700);

        addActor(background);
        addActor(ministriesTable);
        addActor(upgradesButton);
        addActor(patrionsButton);
        addActor(upgradesTable);
        addActor(monthProgress);
        addActor(humanView);
        addActor(moneyLabel);
        addActor(patriotsLabel);

        presenter = new GamePresenter(this);

        setUpListeners();
    }

    private void setUpListeners() {
        humanView.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                presenter.humanClicked();
                return true;
            }
        });

        upgradesButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                presenter.upgradesButtonClicked();
                return true;
            }
        });

        patrionsButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                presenter.patriotsButtonClicked();
                return true;
            }
        });

        for (int counter = 0; counter < upgradesTable.getUpgradeViews().size(); counter++) {
            final int numberOfMinistry = counter;
            ministriesTable.getMinistryView(counter).getLvlUpButton().addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    presenter.ministryClicked(numberOfMinistry);
                    return true;
                }
            });
        }

        setUpgradesListeners();
    }

    void setUpgradesListeners(){
        for (int counter = 0; counter < upgradesTable.getUpgradeViews().size(); counter++) {
            final int numberOfUpgrade = counter;
            upgradesTable.getUpgradeView(counter).addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    presenter.upgradeClicked(numberOfUpgrade);
                }
            });
        }
    }

    @Override
    public void act(float delta) {
        presenter.update(delta);
    }

    public MinistryView getMinistryView(int number) {
        return ministriesTable.getMinistryView(number);
    }


    @Override
    public void setLvlupButtonIsAvaliable(int numberOfMinistry, boolean available) {
        if (available){
            getMinistryView(numberOfMinistry).getLvlUpButton().
                    setTouchable(Touchable.enabled);
            getMinistryView(numberOfMinistry).getLvlUpButton().setColor(1, 1, 1, 1f);
        } else {
            getMinistryView(numberOfMinistry).getLvlUpButton().
                    setTouchable(Touchable.disabled);
            getMinistryView(numberOfMinistry).getLvlUpButton().setColor(1, 1, 1, 0.3f);
        }
    }

    @Override
    public void setMonthProgressWidth(float percent) {
         monthProgress.setProgressWidth((int) (monthProgress.getWidth() * percent));
    }

    @Override
    public void updatePatriotsLabel(int patriots) {
        patriotsLabel.setText(String.valueOf(patriots));
    }

    @Override
    public void updateMoneyLabel(float value) {
        String toShow = String.format("$ %.2f", value);

        if (value > 1000000 && value < 1000000000) {
            toShow = String.format("$ %.2fM", value / 1000000);
        }
        if (value > 1000000000 && value < 1000000000000f) {
            toShow = String.format("$ %.2fM", value / 1000000000);
        }
        moneyLabel.setText(toShow);
    }

    @Override
    public void removeUpgradeView(int number) {
        upgradesTable.removeUpgradeView(number);
    }

    @Override
    public void refreshUpgradesListeners() {
        for (UpgradeView view : upgradesTable.getUpgradeViews()) {
                view.clearListeners();
        }
        setUpgradesListeners();
    }

    @Override
    public void updateMinistryView(int numberOfView, Ministry ministryInfo) {
        getMinistryView(numberOfView).updateInfo(ministryInfo);
    }

    @Override
    public void setUpMinistryViews(ArrayList<Ministry> ministriesInfo) {
        ministriesTable.setUpMinistriesInfo(ministriesInfo);
    }

    @Override
    public void setUpUpgradeViews(ArrayList<Upgrade> upgradesInfo) {
        upgradesTable.setUpUpgradesInfo(upgradesInfo);
    }

    @Override
    public void changeUpgradesTableVisibility() {
        upgradesTable.setVisible(!upgradesTable.isVisible());
    }

    public GamePresenter getPresenter(){
        return presenter;
    }
}
