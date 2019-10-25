import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.application.*;
import javafx.event.*;

public class MazeApplication extends Application {
	Canvas canvas;
	
	public static void main(String[] args) {
		
		
		launch(args);
		
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("OOD A4");
		
		Group root = new Group();
		this.canvas = new Canvas(800, 800);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root, 800, 800);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		MazePrinter mazePrinter = new MazePrinter();
		Maze maze = new Maze(new PrimsMazeGenerator());
		maze.generateMaze(10,10);
		
		Mouse mouse = new Mouse(maze.getStart().getX(), maze.getStart().getY(), new WallFollowerPathfinder(maze));
		maze.getStart().setContents(mouse);
		
		
		MazeDrawer.drawMaze(maze, canvas);	
	}
}