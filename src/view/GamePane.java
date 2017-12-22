package view;

import javafx.scene.Group;
import javafx.stage.Window;

public class GamePane extends Group{
	private GameCanvas gCanvas;
	public GamePane() {
		super();
		gCanvas = new GameCanvas();
	}
	
	public void end() {

		
	}
	
	public GameCanvas getCanvas() {
		return gCanvas;
	}

}
