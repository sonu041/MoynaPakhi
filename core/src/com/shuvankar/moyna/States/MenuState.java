package com.shuvankar.moyna.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shuvankar.moyna.MoynaPakhi;

/**
 * Created by shuvankar on 22/10/17.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MoynaPakhi.WIDTH/2, MoynaPakhi.HEIGHT/2);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playButton, cam.position.x - playButton.getWidth()/2, cam.position.y);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
