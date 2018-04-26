package com.mygdx.elmaze.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.elmaze.ELMaze;

public class MainMenuView extends MenuView {

    // Background
    private Image backgroundImage;

    // Buttons
    private Button playButton;
    private Button instructionsButton;
    private Button creditsButton;
    private Button exitButton;

    public MainMenuView(ELMaze game) {
        super(game, TYPE.MAIN);
        setupButtons();
        setupStage();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI

        handleInputs();
    }

    private void setupButtons() {
        exitButton = ButtonFactory.makeButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*1.15f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        creditsButton = ButtonFactory.makeButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*2.85f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        instructionsButton = ButtonFactory.makeButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*4.55f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
        playButton = ButtonFactory.makeButton( "genericButtonUp.png","genericButtonDown.png",SCREEN_WIDTH/2,
                SCREEN_HEIGHT*6.25f/9, (int)(SCREEN_WIDTH*0.75), (int)(SCREEN_HEIGHT*0.15));
    }

    private void setupStage() {
        stage.addActor(playButton);
        stage.addActor(instructionsButton);
        stage.addActor(creditsButton);
        stage.addActor(exitButton);
    }

    public void handleInputs() {
        if (playButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.CONNECTION));
        }
        if(instructionsButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.INSTRUCTIONS));
        }
        if(creditsButton.isChecked()) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.CREDITS));
        }
        if (exitButton.isPressed()) {
            Gdx.app.exit();
        }
    }

}