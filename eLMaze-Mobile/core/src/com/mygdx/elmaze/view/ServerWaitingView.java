package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.NetworkManager;

public class ServerWaitingView extends MenuView {

    // Background
    private Button exitButton;

    public ServerWaitingView(ELMaze game) {
        super(game, TYPE.SERVER_WAIT);

        loadAssets();
        setupExitButton();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

    private void setupExitButton() {
        exitButton = ButtonFactory.makeButton(game,"exitButtonUp.png","exitButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.13));

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                NetworkManager.getInstance().closeConnection();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
    }

    private void setupStage(){
        stage.addActor(exitButton);
    }

    protected void loadAssets() {
        this.game.getAssetManager().load("exitButtonUp.png" , Texture.class);
        this.game.getAssetManager().load("exitButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
    }
}