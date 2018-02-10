package main;

import controller.MenuControl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.MenuPane;
import view.SceneManager;

import Utility.ResourseLoader;

public class Main extends Application {

	public static final int weight = 900;
	public static final int height = 700;

	private SceneManager sceneManager;
	private MenuControl menuControler;

	@Override
	public void start(Stage primaryStage) {
		try {
			sceneManager = new SceneManager(primaryStage);
			ResourseLoader.LoadResource();
			menuControler = new MenuControl(((MenuPane) sceneManager.getPane("menu")).getMenuCanvas(),
					((MenuPane) sceneManager.getPane("menu")).getMenu());
			menuControler.keyEvent();
			primaryStage.getIcons().add(ResourseLoader.icon);
			primaryStage.setTitle("Prog Chief...Cooking game");
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			sceneManager.goTo("menu");

		} catch (Exception e) {
			e.printStackTrace();
		}
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			Platform.exit();
			System.exit(0);
		});

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}