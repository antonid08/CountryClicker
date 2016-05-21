package com.countryclicker.view;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.countryclicker.model.Ministry;
import com.countryclicker.utils.Constants;

import java.util.ArrayList;


/**
 * Created by Илья on 04.05.2016.
 */
public class MinistriesTable extends Table {
    private static final float X = 00;
    private static final float Y = 00;

    private ArrayList<MinistryView> ministryViews;

    public MinistriesTable(/*ArrayList<Ministry> ministriesInfo*/) {
        setUpBounds();

        setUpMinistryViews(/*ministriesInfo*/);
        setUpTableAndScroller();
    }

    private void setUpTableAndScroller() {
        Table ministriesTable = new Table();
        setDebug(true);
        for (int i = 0; i < ministryViews.size(); i++) {
            ministriesTable.add(ministryViews.get(i));
            ministriesTable.row().pad(15);
        }


        ScrollPane scroller = new ScrollPane(ministriesTable);

        scroller.setFadeScrollBars(false);
        scroller.setOverscroll(false, false);

        add(scroller).padTop(90).padLeft(430);
        setFillParent(true);
    }

    private void setUpMinistryViews(/*ArrayList<Ministry> ministriesInfo*/) {
        ministryViews = new ArrayList<MinistryView>();
        for (/*Ministry ministryInfo : ministriesInfo*/int i = 0; i < Constants.NUMBER_OF_MINISTRIES; i++) {
            ministryViews.add(new MinistryView(/*ministryInfo*/));
        }
    }

    public void setUpMinistriesInfo(ArrayList<Ministry> ministriesInfo) {
        for (int counter = 0; counter < ministriesInfo.size(); counter++) {
            ministryViews.get(counter).setUpButtons(ministriesInfo.get(counter));
        }
    }

    private void setUpBounds() {
        setPosition(X, Y);
    }

    public ArrayList<MinistryView> getMinistryViews() {
        return ministryViews;
    }

    public MinistryView getMinistryView(int number) {
        return ministryViews.get(number);
    }
}
