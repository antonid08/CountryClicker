package com.countryclicker.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 22.03.2016.
 */
public class AssetsManager {
    private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|/?:-+=()*&.;,{}´`'<>";

    private static AssetsManager instance;
    private Skin skin;
    private Texture mainTexture;
    private Animation humanAnimation;
    private TextureRegion bg;
    private TextureRegion human;
    private TextureRegion human_kicked;
    private TextureRegion ministryBg;
    private TextureRegion upgradeMinistryButton;
    private TextureRegion standartButton;

    private TextButton.TextButtonStyle standartButtonStyle;
    private Button.ButtonStyle ministryStyle;

    private BitmapFont standartFont;
    private BitmapFont ministryHeaderFont;
    private BitmapFont ministryDescriptionFont;

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

        generator.dispose(); // don't forget to dispose to avoid memory leaks!


        Skin mainSkin = new Skin();
        mainSkin.addRegions(atlas);

        standartButtonStyle = new TextButton.TextButtonStyle(mainSkin.getDrawable("button-up"),
                mainSkin.getDrawable("button_down"), mainSkin.getDrawable("button-up"),
                standartFont);

        ministryStyle = new Button.ButtonStyle(mainSkin.getDrawable("opened_ministry"),
                mainSkin.getDrawable("opened_ministry"), mainSkin.getDrawable("opened_ministry"));



        skin = new Skin(Gdx.files.internal("skin.json"));

        mainTexture = new Texture(Gdx.files.internal("skin.png"));

        human = new TextureRegion(mainTexture, Constants.HUMAN_TEXTURE_X, Constants.HUMAN_TEXTURE_Y,
                Constants.HUMAN_TEXTURE_WIDTH, Constants.HUMAN_TEXTURE_HEIGHT);
        human_kicked = new TextureRegion(mainTexture, 300, 0, 300, 345);

        TextureRegion[] kickTextures = {human, human_kicked};
        humanAnimation = new Animation(Constants.HUMAN_ONE_FRAME_ANIMATION_LENGTH, kickTextures);
        humanAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        bg = new TextureRegion(mainTexture, Constants.BACKGROUND_TEXTURE_X, Constants.BACKGROUND_TEXTURE_Y,
                Constants.BACKGROUND_TEXTURE_WIDTH, Constants.BACKGROUND_TEXTURE_HEIGHT);

        standartButton = new TextureRegion(mainTexture, Constants.BUTTON_TEXTURE_X, Constants.BUTTON_TEXTURE_Y,
                Constants.BUTTON_TEXTURE_WIDTH, Constants.BUTTON_TEXTURE_HEIGHT);



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

    public TextureRegion getBackground() {
        return bg;
    }

    public TextureRegion getStandartButton() {
        return standartButton;
    }

    public Animation getHumanAnimation() {
        return humanAnimation;
    }

    public Button.ButtonStyle getMinistryButtonStyle(){
        return getMinistryButtonStyle();
    }

    public TextButton.TextButtonStyle getStandartButtonStyle(){
        return standartButtonStyle;
    }
    public BitmapFont getMinistryHeaderFont(){
        return ministryHeaderFont;
    }
    public BitmapFont getMinistryDescriptionFont(){
        return ministryDescriptionFont;
    }
}
