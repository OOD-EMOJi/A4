/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olymp
 */
public class Tile {
    private boolean isWall;

    public Tile(boolean isWall) {
        this.isWall = isWall;
    }

    public boolean isWall() {
        return isWall;
    }

    public void makeWall() {
        isWall = true;
    }

    public void makePath() {
	isWall = false;
    }

	@Override
	public String toString() {
		return (isWall ? "X" : " ");
	}
}
