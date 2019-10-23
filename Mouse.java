public class Mouse implements Thing {
	private int x;
	private int y;
	Pathfinder pathFinder;
	
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
		//stub, will update soon
		
	}
}