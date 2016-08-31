package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Gayming on 8/31/2016.
 */
public class Tile extends Actor {//Actor vs Image?

    public enum Symbol{
        NONE, HORIZONTAL, VERTICAL, SQUARE
        /*
        NONE:       blank
        HORIZONTAL: -
        VERTICAL:   |
        SQUARE:     +
         */
    }

    private int row;
    private int col;

    private ShapeRenderer sr;
    private Color color;
    private Symbol symbol;

    public Tile(int row, int col){
        super();
        this.row = row;
        this.col = col;
        setPosition(row*50, col*50);
        setWidth(50);
        setHeight(50);

        sr = new ShapeRenderer();
        color = Color.WHITE;
        symbol = Symbol.NONE;

        setBounds(getX(), getY(), getWidth(), getHeight());

        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tile","was clicked");
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(color);
        sr.rect(getParent().getX()+getX(), getParent().getY()+getY(), getWidth(), getHeight());
        sr.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.BLACK);
        sr.rect(getParent().getX()+getX(), getParent().getY()+getY(), getWidth(), getHeight());
        sr.end();
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

}
