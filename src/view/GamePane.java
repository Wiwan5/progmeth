package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.stage.Window;
import main.Main;

public class GamePane extends Group{
	private Canvas gCanvas;
	private Timeline gameLoop;
	private KeyFrame kFrame;
	
	
	public GamePane() {
		super();
		gCanvas = new Canvas(Main.weight,Main.height);	
	}
	
	
	
	public void start() {
		
	}
	
	public void end() {

		
	}
	
	public Canvas getCanvas() {
		return gCanvas;
	}

}
