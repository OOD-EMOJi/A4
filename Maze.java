/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olymp
 */
public class Maze {
    Tile[][] tiles;
    MazeGenerator generator;

    public Maze(MazeGenerator generator) {
        this.generator = generator;
    }

    void generateMaze(int width, int height){
//         for (Tile[] a : tiles){
//             for(Tile b : a){
//                 b.makeWall();
//             }
//         }
        tiles = generator.generateMaze( width, height );
    }
    
}
