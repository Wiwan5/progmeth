package view;


import java.util.List;

import Utility.ResoureLoader;
import controller.MainControl;

import controller.MenuTeb;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
//import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import main.Main;
import model.player.Player;

public class MenuPane extends Pane{
	private MenuTeb menu;
	private Canvas mCanvas =new Canvas(Main.weight,Main.height);
	private KeyFrame kFrame;
	private Timeline menuLoop;
	public Font font =Font.font("Time New Roman",FontWeight.BOLD,30);
	private TextField name;
	
	public MenuPane() {
		super();
		this.setPrefSize(Main.weight, Main.height);
		menu = new MenuTeb();		
		name = new TextField();
		
		GraphicsContext gc = mCanvas.getGraphicsContext2D();
		name.setLayoutX(Main.weight/2-180);
		name.setLayoutY(350);
		name.setMinSize(200, 50);
		name.setFont(font);
		name.setVisible(false);
		name.setAlignment(Pos.CENTER);
		name.setPromptText(" TYPE YOUR NAME ");
		kFrame = new KeyFrame(Duration.millis(23), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(menu.getState()==1) {
					bg(gc);
					textname(gc);
					name.setVisible(true);
					drawMenu(gc);
					
				}
				if(menu.getState()==0) {
					bg(gc);
					name.clear();
					name.setVisible(false);
					drawlogo(gc);
					drawMenu(gc);
				}
				if(menu.getState()==2) {
					bg(gc);
					name.setVisible(false);
					textname(gc);
					drawMenu(gc);
				}
			}
		});
		getChildren().addAll(mCanvas, name);
		
		
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

	public Canvas getMenuCanvas() {
		return mCanvas;
	}
	
	
	
	//DRAW CANVAS
	public void bg(GraphicsContext gc) {
		gc.drawImage(ResoureLoader.bg0, 0,0,Main.weight,Main.height);
		/*
		gc.setFill(Color.AQUAMARINE);
		gc.fillRect(10, 10,150, 120);
		*/
	}
	
	public void drawMenu(GraphicsContext gc) {
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		try {
		List<String> m = menu.getMenu();
		for(int i = 0;i<m.size();i++) {
			gc.setFill(Color.BROWN);
			if(i == menu.getSelect())	gc.setFill(Color.CHOCOLATE);
			gc.fillRoundRect(Main.weight/2-100, 500+i*80, 200, 50, 10, 10);
			gc.setTextBaseline(VPos.CENTER);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFont(font);
			if(i == menu.getSelect())	gc.setFill(Color.BEIGE);
			else	gc.setFill(Color.BURLYWOOD);
			gc.fillText((String) m.get(i),Main.weight/2,520+i*80);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void drawlogo(GraphicsContext gc) {
		gc.drawImage(ResoureLoader.logo,Main.weight/2-210,100);
		
		/*gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		Font font1 = new Font("Time New Roman", 100);
		gc.setFont(font1);
		gc.setFill(Color.BLACK);
		gc.fillText("HURRY Lunch!",Main.weight/2,250);
		*/
	}
	
	public void textname(GraphicsContext gc) {
		try{
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(font);
		gc.setFill(Color.SIENNA);
		gc.fillText("Hello, Chief",Main.weight/2-100,280);
		if(menu.getState() == 2)	gc.fillText(Player.name, Main.weight/2-10, 350);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name.getText().trim();
	}
	

}