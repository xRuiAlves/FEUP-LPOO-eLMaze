package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.WallModel;
import com.mygdx.elmaze.view.GameView;

public class WallView extends EntityView {

	public WallView(ELMaze game, EntityModel model) {
		super(game, model);
	}
	
	@Override
	public void update(EntityModel model) {	
		WallModel wall = (WallModel) model;
		
        sprite.setCenter(
        		(wall.getX() + wall.getWidth()/2) / GameView.PIXEL_TO_METER, 
        		(wall.getY() + wall.getHeight()/2) / GameView.PIXEL_TO_METER
        );
    }

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("wall.png");

        sprite = new Sprite(texture, texture.getWidth(), texture.getHeight());
        
		sprite.setSize(
			((WallModel)model).getWidth()/GameView.PIXEL_TO_METER, 
			((WallModel)model).getHeight()/GameView.PIXEL_TO_METER
		);
	}

}