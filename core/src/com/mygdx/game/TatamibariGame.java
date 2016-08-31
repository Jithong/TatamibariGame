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

public class TatamibariGame extends Game {
    private Stage stage;//use scene2d?
    private Board board;

	@Override
	public void create () {

        stage = new Stage(new ScreenViewport());//A viewport where the world size is based on the size of the screen.
        // https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/utils/viewport/ScreenViewport.html
        board = new Board(5,5);

        stage.addActor(board);

        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
	    Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
	}
	
	@Override
	public void dispose () {
		super.dispose();
        stage.dispose();
	}
}
