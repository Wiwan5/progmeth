package controller;

import view.SceneManager;
import view.GamePane;
import view.MenuPane;

public class MainControl {
	GameControl gameC;
	MenuControl menuC;
	SceneManager sceneM;
	private static MainControl crr =null;
	
	
	public MainControl() {
		crr = this;
		sceneM =SceneManager.getCurrent();
		gameC = new GameControl(((GamePane) sceneM.getPane("game")).getCanvas());
		menuC = new MenuControl(((MenuPane) sceneM.getPane("menu")).getMenuCanvas(),((MenuPane) sceneM.getPane("menu")).getMenu());
	}
	
	public void startMain() {
		menuC.keyEvent();
		gameC.keyEvent();
	}
	
	public GameControl getGameControl() {
		return (GameControl) gameC;		
	}
	
	public MenuControl getMenuControl() {
		return (MenuControl) menuC;
	}
	
	public static MainControl getCurrent() {
		return (MainControl) crr;
	}
	
	
	
	
	
}
