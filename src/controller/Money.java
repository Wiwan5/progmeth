package controller;

import java.util.Set;
import Food.Ingredient;
import Food.Plate;

public class Money{
	private static int money ;
	
	public Money(){
		money = 0;
	}
	
	public void check(Set<Ingredient> getIng) {
		if(Menu.menu.containsKey(getIng)) {
			money+=getIng.size()*5;
			Menu.remove(getIng);
		}
	}
	
	
	
}
