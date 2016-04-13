package com.countryclicker.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Илья on 22.03.2016.
 */
public class AssetsManager {
    private Skin skin;

    private Texture mainTexture;

    private TextureRegion bg;
    private TextureRegion human;
    private TextureRegion ministryBg;
    private TextureRegion upgradeMinistryButton;
    private TextureRegion upgradesButton;

    private static AssetsManager instance;

    public static AssetsManager getInstance(){
        if (instance == null){
            instance = new AssetsManager();
        }
        return instance;
    }

    public AssetsManager(){
        skin = new Skin(Gdx.files.internal("uiskin.json"));

       /* FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("garuda.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 12;
        BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!*/
    }

    public Skin getSkin(){
        return skin;
    }

    public TextureRegion getHumanRegion(){
        return human;
    }
}
