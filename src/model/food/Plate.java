package model.food;

import Utility.ResourceLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Plate implements IRenderableFood {
	private static Image image = new Image("file:res/img/plate.png");
	

	private Food foodOnPlate;

	public Plate() {
		foodOnPlate = new Food(false, false, false);
	}

	public boolean canSettleOnPlate(IRenderableFood food) {
		if (!(food instanceof Ingredient)) {
			return false;
		}
		Ingredient ingredient = (Ingredient) food;
		if (ingredient.getState() != Ingredient.COOKED) {
			return false;
		}
		if (ingredient instanceof Meat && foodOnPlate.getIngredient(Food.MEAT) == false) {
			return true;
		} else if (ingredient instanceof Vegetable && foodOnPlate.getIngredient(Food.VEGETABLE) == false) {
			return true;
		} else if (ingredient instanceof Bread && foodOnPlate.getIngredient(Food.BREAD) == false) {
			return true;
		}
		return false;
	}

	public IRenderableFood settleMeatOnPlate() {
		foodOnPlate.setIngredient(Food.MEAT, true);
		System.out.println("Meat already on plate");
		return this;
	}

	public IRenderableFood settleVegtableOnPlate() {
		foodOnPlate.setIngredient(Food.VEGETABLE, true);
		System.out.println("Vegetable already on plate");
		return this;
	}

	public IRenderableFood settleBreadOnPlate() {
		foodOnPlate.setIngredient(Food.BREAD, true);
		System.out.println("Bread already on plate");
		return this;
	}

	public boolean plateHaveFood() {
		return !foodOnPlate.IsfoodEmpty();
	}

	public Food getFoodOnPlate() {
		return foodOnPlate;
	}

	public void dumpFood() {
		foodOnPlate.setIngredient(Food.MEAT, false);
		foodOnPlate.setIngredient(Food.VEGETABLE, false);
		foodOnPlate.setIngredient(Food.BREAD, false);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		gc.setFill(Color.WHITE);
		gc.drawImage(image, x - 35, y - 70, 70, 70);
		double yOfIngredient = y - 27;

		if (foodOnPlate.getIngredient(Food.MEAT) == true) {
			if (foodOnPlate.getIngredient(Food.BREAD) == true) {
				if (foodOnPlate.getIngredient(Food.VEGETABLE) == true) {
					gc.drawImage(ResourceLoader.brVM, x - 25, yOfIngredient - 35, 50, 45);
				} else
					gc.drawImage(ResourceLoader.brMeat, x - 25, yOfIngredient - 35, 50, 45);
			} else if (foodOnPlate.getIngredient(Food.VEGETABLE) == true) {
				gc.drawImage(ResourceLoader.meatV, x - 25, yOfIngredient - 35, 55, 50);
			} else {
				gc.drawImage(ResourceLoader.meat[10], x - 25, yOfIngredient - 30, 45, 40);

			}
		} else if (foodOnPlate.getIngredient(Food.BREAD) == true) {
			if (foodOnPlate.getIngredient(Food.VEGETABLE) == true) {
				gc.drawImage(ResourceLoader.brVeg, x - 25, yOfIngredient - 35, 50, 45);
			} else {
				gc.drawImage(ResourceLoader.bread, x - 25, yOfIngredient - 30, 50, 45);
			}

		} else if (foodOnPlate.getIngredient(Food.VEGETABLE) == true) {
			gc.drawImage(ResourceLoader.veg[7], x - 25, yOfIngredient - 30, 45, 40);

		}
	}

}
