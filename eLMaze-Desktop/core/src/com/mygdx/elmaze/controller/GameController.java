package com.mygdx.elmaze.controller;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.controller.levels.Level;
import com.mygdx.elmaze.controller.levels.MultiPlayerLevel;
import com.mygdx.elmaze.controller.levels.SinglePlayerLevel;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.levels.LevelModel;
import com.mygdx.elmaze.model.levels.MultiPlayerLevelModel;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

public class GameController {
	
	private static GameController instance;
	
	public static final int MAP_WIDTH = 20;
	public static final int MAP_HEIGHT = MAP_WIDTH * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
	private final LinkedList<Level> levels = new LinkedList<Level>();
	private boolean isSinglePlayer = true;
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {}
	
	public World getWorld() {
		return levels.getFirst().getWorld();
	}
	
    public void update(float delta) {
    	levels.getFirst().update(delta);
    }

	public void advanceLevel() {
		levels.removeFirst();
		
		if (levels.isEmpty()) {
			System.out.println("You win! :D");
    		Gdx.app.exit();
		}
	}
	
	public void setSinglePlayerMode() {
		isSinglePlayer = true;
		levels.clear();
		
		for (LevelModel levelModel : GameModel.getInstance().getLevels()) {
			levels.add(new SinglePlayerLevel((SinglePlayerLevelModel) levelModel));
		}
	}
	
	public void setMultiPlayerMode() {
		isSinglePlayer = false;
		levels.clear();
		
		for (LevelModel levelModel : GameModel.getInstance().getLevels()) {
			levels.add(new MultiPlayerLevel((MultiPlayerLevelModel) levelModel));
		}
	}

	public void updateBall(int connectionID, Vector2 forceVector, boolean wake) {
		if (isSinglePlayer) {
			((SinglePlayerLevel) levels.getFirst()).getBallBody().applyForceToCenter(forceVector, wake);
		}
		else {
			if (connectionID == 0) {
				((MultiPlayerLevel) levels.getFirst()).getBall1Body().applyForceToCenter(forceVector, wake);
			}
			else {
				((MultiPlayerLevel) levels.getFirst()).getBall2Body().applyForceToCenter(forceVector, wake);
			}
		}
	}
}
