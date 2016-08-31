package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Gayming on 8/31/2016.
 */
public class Board extends Group {
    private int rows;
    private int cols;
    private Tile[][] tiles;

    public Board(int rows, int cols) {
        super();

        this.rows = rows;
        this.cols = cols;

        tiles = new Tile[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = new Tile(i, j);
                addActor(tiles[i][j]);//adding tiles to group
            }
        }

        setWidth(tiles[0][0].getWidth() * cols);
        setHeight(tiles[0][0].getHeight() * rows);

        setPosition(Gdx.graphics.getWidth() / 2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
        //System.out.println(getX() + ", " + getY());
    }


    public Tile getTile(int row, int col) throws Exception{
        //do i need this try/catch here
        return tiles[row][col];
    }
    public Tile getTile(int index) throws Exception{
        int row = index/rows;
        int col = index%rows;
        return tiles[row][col];
    }

    public void setSymbol(int row, int col, Tile.Symbol symbol){
        Tile tile;
        try{
            tile = getTile(row, col);
        }
        catch(Exception e){
            System.out.println(e.getMessage());//index out of bounds
            return;
        }
        tile.setSymbol(symbol);
    }

}
