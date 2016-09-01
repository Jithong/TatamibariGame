package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.gameobjects.Board;
import com.mygdx.gameobjects.Tile;
import com.mygdx.helpers.InputHandler;

/**
 * manages game objects (tile and board (group of tiles)
 *
 * due to simplicity don't use this class and just use the default Stage claess with custom input inside the TatamibariGame class?
 */
public class GameWorld extends Stage {

    private Board board;
    private Tile tileHit;

    public GameWorld(){
        super(new ScreenViewport());

        board = new Board(5,5);
        addActor(board);

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public Tile hit(float stageX, float stageY, boolean touchable) {
        return (Tile)super.hit(stageX, stageY, touchable);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        tileHit = hit(screenX, screenY, false);//what was touchable again?

        Gdx.app.log("hit","registered by stage");
        if (tileHit != null){
            System.out.println(tileHit.getRow() + ", " + tileHit.getCol());
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        tileHit = hit(screenX, screenY, false);

        Gdx.app.log("drag","registered by stage");
        if (tileHit != null){
            System.out.println(tileHit.getRow() + ", " + tileHit.getCol());
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
    }
}
