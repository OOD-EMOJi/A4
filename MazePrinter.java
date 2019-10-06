/**
 *
 * @author ellie
 */
public class MazePrinter {
    
    public void printMaze(Maze maze) {
        System.out.println();
        for (int i=0; i < maze.tiles.length; i++) {
            for (int j=0; j < maze.tiles[i].length; j++) {
                if (maze.tiles[i][j].isWall())
//                    elegant solution if you are on mac/linux:
//                    System.out.print("██");
                    System.out.print("##");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
