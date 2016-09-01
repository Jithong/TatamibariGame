package com.mygdx.game;

/*
 * Tatamibari
 * 
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.gameobjects.Board;
import com.mygdx.gameobjects.Tile;
import com.mygdx.gameworld.GameWorld;
import com.mygdx.helpers.InputHandler;

public class TatamibariGame extends Game {
    private GameWorld world;//use scene2d?
    private Board board;

	@Override
	public void create () {

        world = new GameWorld(5, 5);
	}


	@Override
	public void render () {
	    Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.act();
        world.draw();
	}
	
	@Override
	public void dispose () {
		super.dispose();
        world.dispose();
	}
}
