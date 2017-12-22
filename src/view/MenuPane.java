package view;


import controller.MainControl;

import controller.MenuTeb;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
//import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class MenuPane extends BorderPane{
	private MenuTeb menu;
	private Canvas mCanvas;
	private KeyFrame kFrame;
	private Timeline menuLoop;
	public MenuPane() {
		super();
		menu = new MenuTeb();
		mCanvas = new MenuCanvas(menu);
		this.setCenter(mCanvas);

		kFrame = new KeyFrame(Duration.millis(23), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				drawCanvas();
			}
		});
		
	}
	
	private void drawCanvas() {
			((MenuCanvas) mCanvas).draw();
	}
	
	
	public void start() {
		MainControl.getCurrent().getMenuControl().reset();
		menuLoop = new Timeline();
		menuLoop.setCycleCount(Timeline.INDEFINITE);
		menuLoop.getKeyFrames().add(kFrame);
		menuLoop.play();
	}
	
	public void stop() {
		menuLoop.stop();
		MainControl.getCurrent().getMenuControl().reset();
	}
	

	//getter
	public MenuTeb getMenu() {
		return menu;
	}

	public MenuCanvas getMenuCanvas() {
		return (MenuCanvas) mCanvas;
	}
	
	
	

}
