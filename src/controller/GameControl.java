package controller;

import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

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
		
		
		
		
	}

}
