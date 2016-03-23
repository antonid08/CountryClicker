package com.countryclicker.utils;

/**
 * Created by Илья on 22.03.2016.
 */
public class Constants {

    //-------------------------------------------------------Positions and sizes----------------------------------------------------------------------//
    public static final int APP_WIDTH = 1024;
    public static final int APP_HEIGHT = 768;

    public static final int HUMAN_WIDTH = 150;
    public static final int HUMAN_HEIGHT = 150;

    public static final int HUMAN_X = 50;
    public static final int HUMAN_Y = 550;

    public static final int MONEY_LABEL_X = 50;
    public static final int MONEY_LABEL_Y = 730;

    public static final int MONTH_PROGRESS_X = 240;
    public static final int MONTH_PROGRESS_Y = 710;
    public static final int MONTH_PROGRESS_WIDTH = 150;
    public static final int MONTH_PROGRESS_HEIGHT = 30;
    public static final int MONTH_PROGRESS_RECTANGLE_BORDER = 3;
    public static final int MONTH_PROGRESS_RECTANGLE_HEIGHT = MONTH_PROGRESS_HEIGHT - MONTH_PROGRESS_RECTANGLE_BORDER * 2;
    public static final int MONTH_PROGRESS_RECTANGLE_WIDTH_MAX = MONTH_PROGRESS_WIDTH - MONTH_PROGRESS_RECTANGLE_BORDER * 2;
    public static final int MONTH_PROGRESS_RECTANGLE_X = MONTH_PROGRESS_X + MONTH_PROGRESS_RECTANGLE_BORDER;
    public static final int MONTH_PROGRESS_RECTANGLE_Y = MONTH_PROGRESS_Y + MONTH_PROGRESS_RECTANGLE_BORDER;

    public static final int MINISTRY_WIDTH = 750;
    public static final int MINISTRY_HEIGHT = 80;
    public static final int FIRST_MINISTRY_X = 250;
    public static final int DISTANCE_BETWEEN_MAIN_AND_INFO_MINISTRY_PART = 50;
    public static final int INFO_MINISTRY_PART_WIDTH = 150;
    public static final int INFO_MINISTRY_PART_X = FIRST_MINISTRY_X + MINISTRY_WIDTH - DISTANCE_BETWEEN_MAIN_AND_INFO_MINISTRY_PART -
            INFO_MINISTRY_PART_WIDTH;

    public static final String NAME_OF_MAIN_FONT = "default-font";

    //------------------------------------------------------------End of positions and sizes------------------------------------------------------------//


    public static final float COST_OF_UPGRADE_MINISTRY_COEF = 1.2f;

    public static final int FIRST_MINISTRY_MONEY_PER_FIRST_MONTH = 5;
    public static final int FIRST_MINISTRY_MONEY_FOR_CLICK = 1;

    public static final int START_LENGTH_OF_MONTH = 4; //in seconds

    public static final float MONEY_PER_MONTH_NEXT_MINISTRY_COEF = 8;

    public static final String[] NAMES_OF_MINISTRIES = {"MVD", "JKH", "MinZdrav", "Ministerstvo kulturi",
    "Ministerstvo oboroni", "Ministerstvo obrazovaniya", "Ministerstvo po nalogam"
    };

    public static final int[] COSTS_OF_MINISTRIES = {16, 180, 2000, 22000, 250000, 2750000, 30250000,
    300000000}; //every next we multiply ~11

}
