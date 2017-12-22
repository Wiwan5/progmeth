package controller;

import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import view.GameCanvas;

public class GameControl {
	private GameCanvas gameC;
	Set<KeyCode> pressKey;
	public GameControl(GameCanvas gameC) {
		this.gameC  = gameC;
		pressKey = new ConcurrentSkipListSet<>();		
	}
	
		
	
	public void keyEvent() {
		gameC.setOnKeyPressed(e->{
			KeyCode code = e.getCode();
			if(!pressKey.contains(code)) {
			if(code == KeyCode.UP) {
				
			}
			else if(code == KeyCode.RIGHT) {
				
			}
			else if(code == KeyCode.LEFT) {
				
			}
			else if(code == KeyCode.P) {
				
			}
			else if(code == KeyCode.SHIFT) {
				
			}
			else if(code == KeyCode.ESCAPE) {
				Platform.runLater(()->{
					Platform.exit();
					System.exit(0);
				});
			}
			}
			
			
		});
		
		gameC.setOnKeyPressed(e->{
			KeyCode code = e.getCode();
			pressKey.remove(code);
		});
		
		
		
	}

}
