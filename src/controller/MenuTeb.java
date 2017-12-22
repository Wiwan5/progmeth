package controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Score.Score;
import view.MenuCanvas;
import view.MenuPane;
import view.SceneManager;
//import view.GameCanvas;
import view.GamePane;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MenuTeb {
	private int select=0;
	private int state=0;
	
	//sound
	/*
	
	private static AudioClip click_sound = new AudioClip(); 	
	
	*/
	
	private List<String> mainMenu = new CopyOnWriteArrayList<>();
	private List<String> playMenu = new CopyOnWriteArrayList<>();
	
	{
		mainMenu.add("Start Game");
		mainMenu.add("Scoreboard");
		mainMenu.add("Exit");

		playMenu.add("Play");
		playMenu.add("Main Menu");
	}
	
	
	public MenuTeb(){}
	public void gotoMainmenu() {
		select = 0;
		state = 0;		
	}
	
	public void gotoPlaymenu() {
		select = 0;
		state = 1;
	}
	public List<String> getMenu() {
		if(state == 0)	return mainMenu;
		return playMenu;
	}
	
	public void changeselect(int i) {
		select+=i;
		int m = getMenu().size();
		if(select >= m||select<0) {
			select= (select + m) % m;
		}
	}
	
	public void enter() {
		if(state ==0) {
			if(select == 0) {
				gotoPlaymenu();
				
			}
			else if(select == 1) {
				Score.read();
			}
			else if(select == 2) {
				Platform.runLater(() -> {
					Platform.exit();
					System.exit(0);
				});
				
			}
		}
		if(state == 1) {
			GamePane gameP = ((GamePane) SceneManager.getCurrent().getPane("game"));
			MenuPane menuP = ((MenuPane) SceneManager.getCurrent().getPane("menu"));
			if(select == 0) {
				
				String name = ((MenuCanvas) menuP.getMenuCanvas()).getName();
				
				if(name.equals(""))	{
					
					Alert alert = new Alert(AlertType.ERROR, "The name is empty.Please type your name", ButtonType.OK);
					alert.setHeaderText(null);
					alert.setTitle("Name is empty");
					alert.showAndWait();	
				
				}
				else {
					//call class that control game and set name of chief
					menuP.stop();
					SceneManager.getCurrent().goTo("game");
					gameP.start();
				}
				
			}
			else if(select == 1) {
				gotoMainmenu();						
				
			}
			
		}
		
	}
	
	public int getSelect() {
		return select;
	}
	
	public int getState() {
		return state;
	}
	

	
}
