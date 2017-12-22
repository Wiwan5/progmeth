package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.stage.Window;

public class GamePane extends Group{
	private GameCanvas gCanvas;
	private Timeline gameLoop;
	private KeyFrame kFrame;
	
	
	public GamePane() {
		super();
		gCanvas = new GameCanvas();	
	}
	
	
	
	public void start() {
		
	}
	
	public void end() {

		
	}
	
	public GameCanvas getCanvas() {
		return gCanvas;
	}

}
