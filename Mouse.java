import java.util.*;

public class Mouse implements Thing {
	private int x;
	private int y;
	Pathfinder pathFinder;
	List<Tile> path;
	int i = 0;
	
	public Mouse(int x, int y, Pathfinder pathFinder) {
		this.pathFinder = pathFinder;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public char draw() {
		return 'o';
	}

	
	public void move() {
		List<Tile> list = pathFinder.findPath();
		for (Tile t : list) {
			this.setX(t.getX());
			this.setY(t.getY());
			this.draw();
		}
	}
}