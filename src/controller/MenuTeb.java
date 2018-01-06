package controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



import Utility.ResourseLoader;
import Utility.Score;
import view.MenuPane;
import view.SceneManager;
import view.GamePane;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.media.AudioClip;
import model.player.Player;

public class MenuTeb {
	private int select=-1;
	private int state=0;
	
	
	private List<String> mainMenu = new CopyOnWriteArrayList<>();
	private List<String> playMenu = new CopyOnWriteArrayList<>();
	private List<String> gamePlayMenu = new CopyOnWriteArrayList<>();
	
	{
		mainMenu.add("Start Game");
		mainMenu.add("Scoreboard");
		mainMenu.add("Exit");
		

		playMenu.add("Play");
		playMenu.add("Main Menu");
		playMenu.add("Exit");
		
		gamePlayMenu.add("Play again");
		gamePlayMenu.add("Scoreboard");
		gamePlayMenu.add("Main Menu");
	}
	
	
	public MenuTeb(){}
	public void gotoMainmenu() {
		select = -1;
		state = 0;		
	}
	
	public void gotoPlaymenu() {
		select = -1;
		state = 1;
	}
	public void gotoGameplaymenu() {
		select = -1;
		state = 2;
	}
	public List<String> getMenu() {
		if(state == 0)	return mainMenu;
		if(state == 1) return playMenu;
		return gamePlayMenu;
	}
	
	public void changeselect(int i) {
		select+=i;
		int m = getMenu().size();
		if(select >= m||select<0) {
			select= (select + m) % m;
		}
	}
	
	public void click() {
		ResourseLoader.click_sound.play();
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
		else if(state == 1) {
			GamePane gameP = ((GamePane) SceneManager.getCurrent().getPane("game"));
			MenuPane menuP = ((MenuPane) SceneManager.getCurrent().getPane("menu"));
			if(select == 0) {
				String name =  menuP.getName();
				if(name.isEmpty())	{
					Alert alert = new Alert(AlertType.ERROR, "The name is empty. Please type your name", ButtonType.OK);
					alert.setHeaderText(null);
					alert.setTitle("Name is empty");
					alert.showAndWait();
				}
				else {
					//call class that control game and set name of chief
					
					menuP.stop();
					SceneManager.getCurrent().goTo("game");
					Player.name = name;
					gotoGameplaymenu();
					gameP.start();
					
				}
		
			}
			else if(select == 1) {
				gotoMainmenu();						
				
			}
			else if(select == 2) {
				
				Platform.runLater(() -> {
					Platform.exit();
					System.exit(0);
				});
				
			}
			
		}
		else if(state == 2) {
			GamePane gameP = ((GamePane) SceneManager.getCurrent().getPane("game"));
			MenuPane menuP = ((MenuPane) SceneManager.getCurrent().getPane("menu"));
			if(select == 0) {
				menuP.stop();
				SceneManager.getCurrent().goTo("game");
				gameP.start();
			}
			else if(select == 1) {
				Score.read();
			}
			else if(select == 2) {
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
	public void setSelect(int i) {
		select = i;
	}

	public void clear() {
		select = -1;
		state = 0;
	}
	
}
