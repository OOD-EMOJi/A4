import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class DepthFirstSearchMazeGenerator implements MazeGenerator {

    public Tile[][] generateMaze(int w, int h) {
        int width = 2 * w + 1;
        int height = 2 * h + 1;
       
        
        boolean[][] tiles = new boolean[width][height];
		boolean[][] visited = new boolean[width][height];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {

				if(x == 0) visited[x][y] = true;
				if(y == 0) visited[x][y] = true;
				if(x == width - 1) visited[x][y] = true;
				if(y == height - 1) visited[x][y] = true;
			}
		}
		
		tiles[0][1] = true;
		tiles[width - 1][height - 2] = true;
		
		int x = 1;
		int y = 1;
		
		Stack<int[]> stack = new Stack<int[]>();
		
		tiles[1][1] = true;
		visited[x][y] = true;
		
		while(areUnvisitedCells(visited)) {	
			ArrayList<int[]> unvisitedNeighbors = getUnvisitedNeighbors(visited, x, y);
			int size = unvisitedNeighbors.size();
			if(size <= 0) {
				while(getUnvisitedNeighbors(visited, x, y).size() == 0 && !stack.isEmpty()) {
					int[] t = stack.pop();
					x = t[0];
					y = t[1];
				}
			}
			else {
				int rand = (int)(Math.random() * size);
				
				if(size > 1) {
					stack.push(new int[]{x,y});
				}
				int[] next = unvisitedNeighbors.get(rand);

				
				//removing walls
				tiles[next[0]][next[1]] = true;
				int wx = (x + next[0]) / 2;
				int wy = (y + next[1]) / 2;
				tiles[wx][wy] = true;
				
				//marking cell
				x = next[0];
				y = next[1];
				visited[x][y] = true;
			}
		}
		
		Tile[][] ret = new Tile[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				ret[i][j] = new Tile(!tiles[i][j]);
			}
		}
		return ret;
    }
	
	public ArrayList<int[]> getUnvisitedNeighbors(boolean[][] visited, int x, int y) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		if( x - 2 >= 0 && !visited[x - 2][y]) {
			ret.add(new int[]{x - 2, y});
		}
		if( x + 2 < visited.length && !visited[x + 2][y]) {
			ret.add(new int[]{x + 2, y});
		}
		if( y - 2 >= 0 && !visited[x][y - 2]) {
			ret.add(new int[]{x, y - 2});
		}
		if( y + 2 < visited[x].length && !visited[x][y + 2]) {
			ret.add(new int[]{x, y + 2});
		}
		return ret;
	}
	
	private boolean areUnvisitedCells(boolean[][] visited) {
		for(int x = 1; x < visited.length; x+=2) {
			for(int y = 1; y < visited[x].length; y+=2) {
				if(visited[x][y] == false) {
					return true;
				}					
			}
		}
		return false;
	}
}
