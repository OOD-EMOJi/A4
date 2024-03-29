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
		this.path = pathFinder.findPath();
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
		if(i < path.size()) {
			
			Tile curr = path.get(i);
			
			this.setX(curr.getX());
			this.setY(curr.getY());
			curr.setContents(this);
			if (i > 0) {
				Tile prev = path.get(i-1);
				prev.setContents(null);
			}
			i++;
		}
	}
	
}