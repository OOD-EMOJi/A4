public class Tile {
	
	private Thing contents;
    private boolean isWall;

    public Tile(boolean isWall) {
        this.isWall = isWall;
		this.contents = null;
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

	public Thing getContents() {
		return contents;
	}
	
	public void setContents(Thing contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return (isWall ? "X" : " ");
	}
}
