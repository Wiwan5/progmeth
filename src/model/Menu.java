package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.food.Food;

public class Menu {
	private static final Food[] ALLMENU = new Food[1];
	
	static {
		ALLMENU[0] = new Food(true,false);
		// add menu
	}
	
	static Food generateMenu() {
		Random r = new Random();
		//return ALLMENU[r.nextInt(ALLMENU.length)];
		Food food = ALLMENU[r.nextInt(ALLMENU.length)];
		//System.out.println(food.printFood());
		return food;
	}
}
