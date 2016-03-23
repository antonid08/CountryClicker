package com.countryclicker.utils;

/**
 * Created by Илья on 22.03.2016.
 */
public class Constants {

    //-------------------------------------------------------Positions and sizes----------------------------------------------------------------------//
    public static final int APP_WIDTH = 1000;
    public static final int APP_HEIGHT = 600;

    public static final int HUMAN_WIDTH = 128;
    public static final int HUMAN_HEIGHT = 128;

    public static final int HUMAN_X = 50;
    public static final int HUMAN_Y = 400;

    public static final int MONEY_LABEL_X = 50;
    public static final int MONEY_LABEL_Y = 550;

    public static final int MONTH_PROGRESS_X = 240;
    public static final int MONTH_PROGRESS_Y = 560;
    public static final int MONTH_PROGRESS_WIDTH = 150;
    public static final int MONTH_PROGRESS_HEIGHT = 30;
    public static final int MONTH_PROGRESS_RECTANGLE_BORDER = 3;
    public static final int MONTH_PROGRESS_RECTANGLE_HEIGHT = MONTH_PROGRESS_HEIGHT - MONTH_PROGRESS_RECTANGLE_BORDER * 2;
    public static final int MONTH_PROGRESS_RECTANGLE_WIDTH_MAX = MONTH_PROGRESS_WIDTH - MONTH_PROGRESS_RECTANGLE_BORDER * 2;
    public static final int MONTH_PROGRESS_RECTANGLE_X = MONTH_PROGRESS_X + MONTH_PROGRESS_RECTANGLE_BORDER;
    public static final int MONTH_PROGRESS_RECTANGLE_Y = MONTH_PROGRESS_Y + MONTH_PROGRESS_RECTANGLE_BORDER;

    public static final int MINISTRY_WIDTH = 300;
    public static final int MINISTRY_HEIGHT = 50;
    public static final int FIRST_MINISTRY_X = 200;
    public static final int FIRST_MINISTRY_Y = 500;
    public static final int DISTANCE_BETWEEN_MINISTRIES = 30;
    public static final int DISTANCE_BETWEEN_MAIN_AND_INFO_MINISTRY_PART = 50;
    public static final int INFO_MINISTRY_PART_WIDTH = 150;
    public static final int INFO_MINISTRY_PART_X = FIRST_MINISTRY_X + MINISTRY_WIDTH + DISTANCE_BETWEEN_MAIN_AND_INFO_MINISTRY_PART;

    public static final String NAME_OF_MAIN_FONT = "default-font";

    //------------------------------------------------------------End of positions and sizes------------------------------------------------------------//

    public static final float COST_OF_NEXT_MINISTRY_COEF = 10;
    public static final float MONEY_PER_MONTH_FOR_NEXT_MINISTRY_COEF = 10;

    public static final float COST_OF_UPGRADE_MINISTRY_COEF = 1.2f;
    public static final float MONEY_PER_MONTH_FOR_NEXT_LEVEL_COEF = 1.6f;

    public static final int FIRST_MINISTRY_COST = 10;
    public static final int FIRST_MINISTRY_MONEY_PER_FIRST_MONTH = 2;

    public static final int START_LENGTH_OF_MONTH = 4; //in seconds

}
