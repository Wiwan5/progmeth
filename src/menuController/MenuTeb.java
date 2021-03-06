package menuController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Utility.ResourceLoader;
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
	private int select = -1;
	private int state = 0;

	private List<String> mainMenu = new CopyOnWriteArrayList<>();
	private List<String> gamePlayMenu = new CopyOnWriteArrayList<>();

	{
		mainMenu.add("");
		mainMenu.add("Start Game");
		mainMenu.add("Scoreboard");

	
		gamePlayMenu.add("Play again");
		gamePlayMenu.add("Scoreboard");
		gamePlayMenu.add("New Player");
	}

	private void gotoMainmenu() {
		select = -1;
		state = 0;
	}

	private void gotoGameplaymenu() {
		select = -1;
		state = 1;
	}

	public List<String> getMenu() {
		if (state == 0)
			return mainMenu;
		return gamePlayMenu;
	}

	public void click() {
		ResourceLoader.click_sound.play();
		if (state == 0) {
			GamePane gameP = ((GamePane) SceneManager.getCurrent().getPane("game"));
			MenuPane menuP = ((MenuPane) SceneManager.getCurrent().getPane("menu"));
			if (select == 1) {
				String name = menuP.getName();
				if (name.isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR, "The name is empty. Please type your name", ButtonType.OK);
					alert.setHeaderText(null);
					alert.setTitle("Name is empty");
					alert.showAndWait();
					select = -1;
				} else {
					// call class that control game and set name of chief
					select = -1;
					menuP.stop();
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							SceneManager.getCurrent().goTo("game");
							Player.setName(name);
							gotoGameplaymenu();
							gameP.start();
						}
					});
					

				}

			} else if (select == 2) {
				Score.read();
				select = -1;
			} 

		} else if (state == 1) {
			GamePane gameP = ((GamePane) SceneManager.getCurrent().getPane("game"));
			MenuPane menuP = ((MenuPane) SceneManager.getCurrent().getPane("menu"));
			if (select == 0) {
				menuP.stop();
				select = -1;
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						SceneManager.getCurrent().goTo("game");
						gameP.start();
					}
				});
			} else if (select == 1) {
				Score.read();
				select = -1;
			} else if (select == 2) {
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

	

}
