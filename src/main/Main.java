package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menuController.MenuControl;
import view.MenuPane;
import view.SceneManager;

import java.awt.Graphics2D;

import Utility.ResourceLoader;

public class Main extends Application {

	public static final int width = 900;
	public static final int height = 700;

	private SceneManager sceneManager;
	private MenuControl menuControler;

	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneManager = new SceneManager(primaryStage);
		MenuPane menuPane = (MenuPane) sceneManager.getPane("menu");
		menuPane.getMenuCanvas().requestFocus();
		menuControler = new MenuControl(menuPane.getMenuCanvas(), menuPane.getMenu());
		menuControler.keyEvent();
		primaryStage.getIcons().add(ResourceLoader.icon);
		primaryStage.setTitle("Prog Chief...Cooking game");
		primaryStage.setResizable(false);
		
		menuPane.start();
		primaryStage.setMaxWidth(Main.width);
		primaryStage.show();
		sceneManager.firstTime();
		primaryStage.setOnCloseRequest(event -> {
			Platform.exit();
			System.exit(0);
		});
		// TODO Auto-generated method stub
		
		
	
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}