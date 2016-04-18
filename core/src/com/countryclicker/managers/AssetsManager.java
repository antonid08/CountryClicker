package com.countryclicker.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.countryclicker.utils.Constants;

/**
 * Created by Илья on 22.03.2016.
 */
public class AssetsManager {
    private Skin skin;

    private Texture mainTexture;

    private Animation humanAnimation;

    private TextureRegion bg;
    private TextureRegion human;
    private TextureRegion human_kicked;
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
        mainTexture = new Texture(Gdx.files.internal("texture_atlas.png"));

        human = new TextureRegion(mainTexture, 0, 0, 300, 345);
        human_kicked = new TextureRegion(mainTexture, 300, 0, 300, 345);

        TextureRegion[] kickTextures = { human, human_kicked };
        humanAnimation = new Animation(Constants.HUMAN_ONE_FRAME_ANIMATION_LENGTH, kickTextures);
        humanAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

       /* FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("garuda.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 12;
        BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!*/
    }

    public Skin getSkin(){
        return skin;
    }

    public Animation getHumanAnimation(){
        return humanAnimation;
    }
}
