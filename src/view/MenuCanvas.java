package view;

import java.util.List;

import controller.MenuTeb;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import main.Main;

public class MenuCanvas extends Canvas{
	GraphicsContext gc = getGraphicsContext2D();
	public Font font =Font.font("Time New Roman",FontWeight.BOLD,30);
	private TextField nameField;
	private MenuTeb menu;
	
	
	public MenuCanvas(MenuTeb menu){
		super();
		this.menu = menu;
		this.setWidth(Main.weight);
		this.setHeight(Main.height);
		 nameField = new TextField();
		 nameField.setMaxWidth(300);
		 nameField.setMinWidth(300);
		 nameField.setLayoutX(Main.weight/2);
		 nameField.setLayoutY(400);
		 nameField.setFont(font);
		 nameField.setStyle("-fx-text-alignment:center;");
		 nameField.setVisible(false);
		
	}
	
	public void draw() {
		//bg();
		
		if(menu.getState()==0)	drawlogo();
		else if(menu.getState() == 1)	textname();
		
		drawMenu(); 
	}
	
	/*
	public void bg() {
		
	}
	*/
	public void drawMenu() {
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		try {
		List<String> m = menu.getMenu();
		for(int i = 0;i<m.size();i++) {
			gc.setFill(Color.BROWN);
			if(i == menu.getSelect())	gc.setFill(Color.CHOCOLATE);
			gc.fillRoundRect(Main.weight/2-100, 480+i*80, 200, 50, 10, 10);
			gc.setTextBaseline(VPos.CENTER);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFont(font);
			if(i == menu.getSelect())	gc.setFill(Color.BEIGE);
			else	gc.setFill(Color.BURLYWOOD);
			gc.fillText((String) m.get(i),Main.weight/2,500+i*80);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void drawlogo() {
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		Font font1 = new Font("Time New Roman", 100);
		gc.setFont(font1);
		gc.setFill(Color.BLACK);
		gc.fillText("HURRY Lunch!",Main.weight/2,250);
		nameField.setVisible(false);
	}
	
	public void textname() {
		try{
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(font);
		gc.setFill(Color.SIENNA);
		gc.fillText("Hello, Chief",Main.weight/2-100,280);
		nameField.setVisible(true);
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getName() {
		if(nameField.getText().trim().isEmpty()) {
			return "";
		}
		return nameField.getText().trim();
	}
	
	
	
	
	
	
}
