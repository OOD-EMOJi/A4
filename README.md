# Maze Project 🙀🌟👀🙃🐭

A Maze.

## Installation

Download and unzip all the files into one folder, then run Driver

## Code reference

![class diagram](Flowchart.png)

### Maze Contents

#### Tiles

Everything inside the Maze lives inside a `Tile`. 

Each `Tile` has a location {`int x`, `int y`} and optionally an inhabitant `Thing contents`.

`Tile` that are walls (`isWall`) cannot be inhabited.

#### Maze class

The `Maze` contains a reference `Tile[][] tiles` to each tile and their location.

It also knows which Tile is the maze entrance `Tile start` and goal `Tile end`.

`Maze` contains a `MazeGenerator generator` which is responsible for creating the layout of the maze. **You must run `generateMaze(int width, int height)` on a new Maze before attempting to traverse it.** All Tiles are null before generateMaze is called.

#### MazeGenerator

There are [many different ways] to create a maze! The `MazeGenerator` interface allows for the use of different algorithms to draw a maze, producing different types of passages.

`Tile[][] generateMaze(int w, int h)`: Given the size of a Maze, determine which Tiles are walls and which are paths, then return the newly populated tiles.

[many different ways]: http://weblog.jamisbuck.org/2011/2/7/maze-generation-algorithm-recap

#### Things

A `Thing` is anything that lives inside a `Tile` that is not a wall or path. Each `Thing` has a location {`int x`, `int y`} that matches the location of the `Tile` it inhabits, and a character to represent itself visually.

`public char draw()` returns the character representing the Thing.

`public void move()` updates the Thing's location, sets its previous Tile's `contents` to null, and inserts itself into its new Tile's `contents`. If a `Thing` is stationary, `move()` is blank.

### Movement

#### The Mouse 🐭

The Mouse's goal is to get to the end of the maze, no matter the cost. It is currently unknown if the end of the maze contains cheese. What we do know is that our Mouse will stop at nothing to solve any puzzle presented to it.

`public class Mouse implements Thing`, so `Mouse` knows where it is located and what character it looks like.

`Mouse` can travel the `Maze` in [any number of different ways]. It contains a `List<Tile> path` to travel, a `Pathfinder pathfinder` that is responsible for generating this path, and an `int i` that keeps track of where in the path it is.

[any number of different ways]: https://en.wikipedia.org/wiki/Maze_solving_algorithm
