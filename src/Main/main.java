package main;

import controller.MainControl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.SceneManager;


public class Main extends Application {

	public static int weight = 1200;
	public static int height = 800;

	private SceneManager sceneManager;
	private MainControl mainController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneManager = new SceneManager(primaryStage);

		mainController = new MainControl();
		mainController.startMain();

		primaryStage.setTitle("TOU...Cooking game");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(event -> {
			Platform.exit();
			System.exit(0);
		});

		sceneManager.goTo("menu");
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}

