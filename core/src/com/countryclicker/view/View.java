package com.countryclicker.view;

import com.countryclicker.model.Ministry;
import com.countryclicker.model.Upgrade;

import java.util.ArrayList;

/**
 * Created by Илья on 19.05.2016.
 */
public interface View {
    void setLvlupButtonIsAvaliable(int numberOfMinistry, boolean available);
    void setMonthProgressWidth(float percent);
    void updatePatriotsLabel(int patriots);
    void updateMoneyLabel(float value);
    void removeUpgradeView(int number);
    void refreshUpgradesListeners();
    void updateMinistryView(int numberOfView, Ministry ministryInfo);
    void setUpMinistryViews(ArrayList<Ministry> ministriesInfo);
    void setUpUpgradeViews(ArrayList<Upgrade> upgradesInfo);
    void changeUpgradesTableVisibility();
}
