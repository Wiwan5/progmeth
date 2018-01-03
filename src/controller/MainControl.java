package controller;

import view.SceneManager;

import view.MenuPane;

public class MainControl {
	MenuControl menuC;
	SceneManager sceneM;
	private static MainControl crr =null;
	
	
	public MainControl() {
		crr = this;
		sceneM =SceneManager.getCurrent();
		menuC = new MenuControl(((MenuPane) sceneM.getPane("menu")).getMenuCanvas(),((MenuPane) sceneM.getPane("menu")).getMenu());
	}
	
	public void startMain() {
		menuC.keyEvent();
	}
	public MenuControl getMenuControl() {
		return (MenuControl) menuC;
	}
	
	public static MainControl getCurrent() {
		return (MainControl) crr;
	}
	
	
	
	
	
}
