package controller;

import java.util.Set;
import java.util.Map;

import Food.Ingredient;

public class Menu {
	public static Map<Set<Ingredient>,Time> menu;
	private Map<Time,Set<Ingredient>> t;
	
	public Menu(){
		
	}

	public static void remove(Set<Ingredient> key) {
		menu.remove(key);
		//a lot of thing to do here
		
		
		
	}
	

	public void checkOut() {
		
	}
	
}
