package controller;

import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;


public class GameControl {
	private Canvas gameC;
	private Set<KeyCode> pressKey;
	public GameControl(Canvas gameC) {
		this.gameC  = gameC;
		pressKey = new ConcurrentSkipListSet<>();		
	}
	
		
	
	public void keyEvent() {
		gameC.setOnKeyPressed(e->{
			KeyCode code = e.getCode();
			if(!pressKey.contains(code)) {
				pressKey.add(code);
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
	
	public void clear() {
		pressKey.clear();
	}
	

}
