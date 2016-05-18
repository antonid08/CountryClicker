package com.countryclicker.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.model.ClickMinistry;
import com.countryclicker.model.Ministry;
import com.countryclicker.model.MonthMinistry;

import java.util.ArrayList;


/**
 * Created by Илья on 04.05.2016.
 */
public class MinistriesTable extends Table{
    private static final float X = 00;
    private static final float Y = 00;

    private ArrayList<MinistryView> ministryViews;

    public MinistriesTable(ArrayList<Ministry> ministriesInfo){
        //setDebug(true);
        setUpBounds();

        setUpMinistryViews(ministriesInfo);
        setUpTableAndScroller();
        //TODO in table create view for each ministry


    }

    private void setUpTableAndScroller(){
        Table ministriesTable = new Table();

        for (int i = 0; i < ministryViews.size(); i++){
            ministriesTable.add(ministryViews.get(i));
            ministriesTable.row().pad(15);
        }


        ScrollPane scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller).padTop(90).padLeft(430);
        setFillParent(true);
    }

    private void setUpMinistryViews(ArrayList<Ministry> ministriesInfo){
        ministryViews = new ArrayList<MinistryView>();
        for(Ministry ministryInfo: ministriesInfo){
            ministryViews.add(new MinistryView(ministryInfo));
        }
    }



    private void setUpBounds(){
        setPosition(X, Y);
    }

    public MinistryView getMinistryView(int number){
        return ministryViews.get(number);
    }
}
