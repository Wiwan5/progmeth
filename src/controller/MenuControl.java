package controller;



import java.awt.Desktop.Action;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javafx.application.Platform;
//import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import main.Main;


public class MenuControl {
	MenuTeb menu;
	Canvas menuC;
	private Set<KeyCode> keyPress;
	
	public MenuControl(Canvas mCanvas,MenuTeb menu) {
		this.menu = menu;
		this.menuC = mCanvas;
		keyPress = new ConcurrentSkipListSet<>();
		
	}
	
	public void keyEvent(){
		menuC.setOnKeyPressed(event -> {
			KeyCode code = event.getCode();
			if (!keyPress.contains(code)) {
				keyPress.add(code);
				if(code == KeyCode.ESCAPE) {
					
				}
			}
			
		});

		menuC.setOnKeyReleased(event -> {
			KeyCode code = event.getCode();
			keyPress.remove(code);
		});
		
		
		menuC.setOnMouseMoved(e->{
			if(e.getX()>=Main.weight/2-100&&e.getY()>=500&& e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50) {
				System.out.println("Menu1");
				menu.setSelect(0);
			}
			else if(e.getX()>=Main.weight/2-100&&e.getY()>=500+80&& e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50+80) {
				System.out.println("Menu2");
				menu.setSelect(1);
			}
			else if(e.getX()>=Main.weight/2-100&&e.getY()>=500+80+80&&e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50+80+80)	{
				System.out.println("Menu3");
				menu.setSelect(2);
			}
			else	menu.setSelect(-1);
		});
		
		
		menuC.setOnMousePressed(e->{
			System.out.println("Click");
			if((e.getX()>=Main.weight/2-100&&e.getY()>=500&& e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50)||
					(e.getX()>=Main.weight/2-100&&e.getY()>=500+80&& e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50+80)
					||(e.getX()>=Main.weight/2-100&&e.getY()>=500+80+80&& 
							e.getX()<=200+Main.weight/2-100&&e.getY()<=500+50+80+80))	
				menu.click();
		});
		
		
		
		
		
	}
	
	public void reset() {
		keyPress.clear();
	}
	
}
