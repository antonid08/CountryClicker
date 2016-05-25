package com.countryclicker.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Илья on 22.03.2016.
 */
public class AssetsManager {
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|/?:-+=()*&.;,{}´`'<>";

    private static AssetsManager instance;
    private Skin skin;

    private TextButton.TextButtonStyle standartButtonStyle;
    private Button.ButtonStyle ministryStyle;
    private Button.ButtonStyle openedMinistryStyle;
    private Button.ButtonStyle lvlupButtonStyle;

    private BitmapFont standartFont;
    private BitmapFont ministryHeaderFont;
    private BitmapFont ministryDescriptionFont;
    private BitmapFont upgradeHeaderFont;
    private BitmapFont upgradeDescriptionFont;


    public AssetsManager() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skin.atlas"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Days.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARACTERS;

        parameter.size = 16;
        parameter.color = Color.GOLDENROD;
        standartFont = generator.generateFont(parameter); // font size 12 pixels

        parameter.color = Color.WHITE;

        parameter.size = 30;
        ministryHeaderFont = generator.generateFont(parameter);

        parameter.size = 23;
        ministryDescriptionFont = generator.generateFont(parameter);

        parameter.size = 25;
        upgradeHeaderFont = generator.generateFont(parameter);

        parameter.size = 18;
        upgradeDescriptionFont = generator.generateFont(parameter);

        generator.dispose(); // don't forget to dispose to avoid memory leaks!


        Skin mainSkin = new Skin();
        mainSkin.addRegions(atlas);

        standartButtonStyle = new TextButton.TextButtonStyle(mainSkin.getDrawable("button-up"),
                mainSkin.getDrawable("button-down"), mainSkin.getDrawable("button-up"),
                standartFont);

        ministryStyle = new Button.ButtonStyle(mainSkin.getDrawable("opened_ministry"),
                mainSkin.getDrawable("opened_ministry"), mainSkin.getDrawable("opened_ministry"));

        openedMinistryStyle = new Button.ButtonStyle(mainSkin.getDrawable("opened_ministry"),
                mainSkin.getDrawable("opened_ministry"), mainSkin.getDrawable("opened_ministry"));

        lvlupButtonStyle = new Button.ButtonStyle(mainSkin.getDrawable("lvlup_button_up"),
                mainSkin.getDrawable("lvlup_button_down"), mainSkin.getDrawable("lvlup_button_up"));


        skin = new Skin(Gdx.files.internal("skin.json"));
    }

    public static AssetsManager getInstance() {
        if (instance == null) {
            instance = new AssetsManager();
        }
        return instance;
    }

    public Skin getSkin() {
        return skin;
    }


    public Button.ButtonStyle getLvlupButtonStyle() {
        return lvlupButtonStyle;
    }

    public Button.ButtonStyle getMinistryButtonStyle() {
        return ministryStyle;
    }

    public TextButton.TextButtonStyle getStandartButtonStyle() {
        return standartButtonStyle;
    }

    public BitmapFont getMinistryHeaderFont() {
        return ministryHeaderFont;
    }

    public BitmapFont getMinistryDescriptionFont() {
        return ministryDescriptionFont;
    }

    public BitmapFont getUpgradeHeaderFont() {
        return upgradeHeaderFont;
    }

    public BitmapFont getUpgradeDescriptionFont() {
        return upgradeDescriptionFont;
    }

}
