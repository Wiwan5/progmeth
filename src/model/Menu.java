package model;

import java.util.ArrayList;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import Utility.Pair;
import Utility.ResourseLoader;
import Utility.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.counter.Counter;
import model.exception.menuException;
import model.food.Food;

public class Menu {
	public static CopyOnWriteArrayList<Pair<Food, Time>> allMenu;
	public static ArrayList<Pair<Double, Double>> position = new ArrayList<>();
	static {
		position.add(Pair.make_pair(0.0, 0.0));
		position.add(Pair.make_pair(180.0, 0.0));
		position.add(Pair.make_pair(360.0, 0.0));
		position.add(Pair.make_pair(540.0, 0.0));
		position.add(Pair.make_pair(720.0, 0.0));

	}

	public Menu() {
		// TODO Auto-generated constructor stub
		allMenu = new CopyOnWriteArrayList();
	}

	public Pair<Food, Time> generateMenu() {
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;
		Food food = null;
		Time t = null;
		if (n == 1) {
			food = new Food(false, true, true);
			t = new Time(30000);
		}
		if (n == 2) {
			food = new Food(true, true, true);
			t = new Time(60000);
		}
		if (n == 3) {
			food = new Food(true, false, true);
			t = new Time(50000);
		}

		Pair<Food, Time> e = Pair.make_pair(food, t);
		allMenu.add(e);
		return e;

	}

	public boolean remove(Food food) {
		for (Pair<Food, Time> menu : allMenu) {
			if (menu.first.equals(food)) {
				allMenu.remove(menu);
				return true;

			}
		}
		return false;
	}

	public void updateMenu(GraphicsContext gc) throws menuException {
		int ch = 0;
		boolean remove = false;
		for (Pair<Food, Time> menu : allMenu) {
			if (menu.second.isTimeup())
				remove = true;
			draw(Menu.position.get(ch), menu, gc);
			drawTime(Menu.position.get(ch), menu, gc);
			ch++;

		}
		if (remove) {
			for (Pair<Food, Time> menu : allMenu) {
				if (menu.second.isTimeup()) {
					allMenu.remove(menu);

				}

			}
		}
		if (allMenu.size() == 0 || allMenu.size() >= 4)
			throw new menuException();

		if (allMenu.size() <= 2) {
			generateMenu();
		}
	}

	private void draw(Pair<Double, Double> pos, Pair<Food, Time> menu, GraphicsContext gc) {
		// TODO Auto-generated method stub
		double x = pos.first;
		double y = pos.second;
		gc.setFill(Color.HONEYDEW);
		gc.fillRect(x + 10, y, 130, 100);
		gc.drawImage(ResourseLoader.bread, x + 20, y + 60, 30, 30);

		if (menu.first.getIngredient(0) == true) {
			gc.drawImage(ResourseLoader.meat[0], x + 55, y + 60, 30, 30);

		}
		if (menu.first.getIngredient(1) == true) {
			gc.drawImage(ResourseLoader.veg[0], x + 90, y + 60, 30, 30);
		}
	}

	public void drawTime(Pair<Double, Double> pos, Pair<Food, Time> menu, GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.web("#122335"));
		gc.fillRect(pos.first + 10, pos.second + 10, 130, 20);
		gc.setFill(Color.web("#7EB19E"));
		gc.fillRect(pos.first + 10, pos.second + 10, (menu.second.getReduce()) <= 0 ? 0.01 : menu.second.getReduce(),
				20);

	}

}
