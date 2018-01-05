package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Utility.Pair;
import Utility.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.counter.Counter;
import model.food.Food;

public class Menu {
	
	public static ArrayList<Pair<Double,Double>> position = new ArrayList<>();
	static {
		position.add(Pair.make_pair(0.0,0.0));
		position.add(Pair.make_pair(200.0, 0.0));
		position.add(Pair.make_pair(400.0, 0.0));
		position.add(Pair.make_pair(600.0, 0.0));
		position.add(Pair.make_pair(800.0, 0.0));
		
	}
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Pair<Food,Time> generateMenu() {
			Random rand = new Random();
			int n = rand.nextInt(3) + 1;
			Food food = null;
			Time t = null;
			if(n==1) {
				food = new Food(false,true,true);
				t = new Time(30000);
			}
			if(n==2) {
				food = new Food(true,true,true);
				t = new Time(40000);
			}
			if(n==3) {
				food = new Food(true,false,true);
				t = new Time(20000);
			}
			
			Pair<Food, Time> e =Pair.make_pair(food,t);
			return e;
		
	}
	
	

}
