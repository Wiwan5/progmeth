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
		
	}
	
	public void draw() {
		/*if(menu.state==0)	drawlogo();
		else if(menu.state == 1)	textname();
		*/
		drawMenu(); 
	}
	
	
	
	
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
		
	}
	
	public void textname() {
		try{
			
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(font);
		gc.setFill(Color.SIENNA);
		gc.fillText("Hello, Chief",200,100);
		
		//Textfill name player
		 nameField = new TextField();
		 nameField.setMaxWidth(400);
		 nameField.setMinWidth(400);
		 nameField.setLayoutX(300);
		 nameField.setLayoutY(230);
		 nameField.setStyle("-fx-background-color:white;"
		    		+ "-fx-font-size:28px;"
		    		+ "-fx-font-family:Consolas;"
		    		+ "-fx-alignment:center;"
		    		+ "-fx-border-width:2.5px;"
		    		+ "-fx-border-color:sienna;"
		    		+ "-fx-border-radius:5px;");

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getName() {
		if(nameField.getText().trim().equals("")) {
			return "";
		}
		else return nameField.getText().trim();
	}
	
	
	
	
	
	
}
