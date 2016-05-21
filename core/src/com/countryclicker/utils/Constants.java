package com.countryclicker.utils;

/**
 * Created by Илья on 22.03.2016.
 */
public class Constants {

    public static final String SAVE_FILE_NAME = "saved_game_state";
    public static final String TIME_FILE_NAME = "time";

    public static final int START_MONEY = 10000;
    public static final int PERCENT_FOR_PATRIOT = 2;

    //-------------------------------------------------------Positions and sizes----------------------------------------------------------------------//
    public static final int APP_WIDTH = 1611;
    public static final int APP_HEIGHT = 768;

    public static final int MONEY_LABEL_X = 50;
    public static final int MONEY_LABEL_Y = 730;


    public static final int MONTH_PROGRESS_X = 240;
    public static final int MONTH_PROGRESS_Y = 710;



    public static final String NAME_OF_MAIN_FONT = "default-font";

    //------------------------------------------------------------End of positions and sizes------------------------------------------------------------//
    public static final int NUMBER_OF_MINISTRIES = 7;
    public static final int NUMBER_OF_UPGRADES = 5;

    public static final float COST_OF_UPGRADE_MINISTRY_COEF = 1.2f;
    public static final float COST_OF_UPGRADE_MVD_MINISTRY_COEF = 2.1f;

    public static final int FIRST_MINISTRY_MONEY_PER_FIRST_MONTH = 5;
    public static final int FIRST_MINISTRY_MONEY_FOR_CLICK = 1;

    public static final int START_LENGTH_OF_MONTH = 4; //in seconds

    public static final float MONEY_PER_MONTH_NEXT_MINISTRY_COEF = 8;

    public static final float START_TIME_TO_KICK_MVD = 10;

    public static final String[] NAMES_OF_MINISTRIES = {"Министерство внутренних дел", "Жилищно-коммунальное хозяйство",
            "Министерство здравоохранения", "Министерство культуры", "Министерство обороны", "Министерство образования",
            "Министерство магии"
    };

    public static final int[] COSTS_OF_MINISTRIES = {16, 180, 2000, 22000, 250000, 2750000, 30250000,
    300000000}; //every next we multiply ~11

    //---------------------------------------------------------------Animation Block-------------------------------------------------//
    public static final float HUMAN_HIT_ANIMATION_TIME = 0.5f;
    public static final int HUMAN_HIT_ANIMATION_NUMBER_OF_FRAMES = 2;
    public static final float HUMAN_ONE_FRAME_ANIMATION_LENGTH = HUMAN_HIT_ANIMATION_TIME / HUMAN_HIT_ANIMATION_NUMBER_OF_FRAMES;
}
