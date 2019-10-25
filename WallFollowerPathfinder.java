import java.util.*;

public class WallFollowerPathfinder implements Pathfinder {
    
    /* * * * * * * * * *
     * WALL  FOLLOWER: *
     * * * * * * * * * *
     * keeps a hand on the rightmost wall and follows wherever that wall goes.
     * By keeping a hand (...paw? claw? What do mice have?)
     * on the railing, the mouse is guaranteed not to get lost.
     * They will eventually reach an exit if there is one.
     * (Our maze always has an exit.)
     */
    
    Maze maze;
    
    public WallFollowerPathfinder(Maze m) {
        maze = m;
    }
    
    public List<Tile> findPath() {
        Tile c = maze.getStart();
        Tile prev;
        
        LinkedList<Tile> path = new LinkedList<Tile>();
        HashSet<Tile> visited = new HashSet<Tile>();
        
        while (c != maze.getEnd()) {
            path.add(c);
            visited.add(c);
            int x = c.getX(), y = c.getY();
            Tile west = maze.tiles[x-1][y], east = maze.tiles[x+1][y];
            Tile north = maze.tiles[x][y-1], south = maze.tiles[x][y+1];
            if (south.isWall() && !east.isWall() && !visited.contains(south) && !visited.contains(east)) {
                c = east;
            } else if (!south.isWall() && !visited.contains(south)) {
                c = south;
            } else if (!north.isWall() && east.isWall() && !visited.contains(north) && !visited.contains(east)) {
                c = north;
            } else if (east.isWall() && !west.isWall() && !visited.contains(east) && !visited.contains(west)) {
                c = west;
            } else {
                System.out.println("bro wtf");
            }
        }
        return path;
    }
}
