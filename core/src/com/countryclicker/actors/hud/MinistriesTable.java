package com.countryclicker.actors.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.stages.GameStage;

import javafx.scene.control.Tab;

/**
 * Created by Илья on 04.05.2016.
 */
public class MinistriesTable extends Table{
    private static final float X = 000;
    private static final float Y = 00;

    public MinistriesTable(GameStage stage){
//        setDebug(true);
        setUpBounds();

        Table ministriesTable = new Table();
        ministriesTable.add(stage.getClickMinistry());
        ministriesTable.row().pad(15);

        for (int i = 0; i < stage.getMonthMinistries().length; i++){
            ministriesTable.add(stage.getMonthMinistries()[i]);
            ministriesTable.row().pad(15);
        }


        ScrollPane scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller).padTop(90).padLeft(300);
        setFillParent(true);
    }

    private void setUpBounds(){
        setPosition(X, Y);
    }
}
