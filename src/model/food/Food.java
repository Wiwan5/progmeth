package model.food;

import java.util.Arrays;

public class Food {

	public static final int MEAT = 0;
	public static final int VEGETABLE = 1;
	public static final int BREAD = 2;

	private static final int AMOUNT_INGREDIENT = 3;
	private Boolean[] ingredients = new Boolean[AMOUNT_INGREDIENT];

	public Food(boolean haveMeat, boolean haveVegetable, boolean haveBread) {
		ingredients[MEAT] = haveMeat;
		ingredients[VEGETABLE] = haveVegetable;
		ingredients[BREAD] = haveBread;
	}

	@Override
	public boolean equals(Object o) {
		Food food = (Food) o;
		for (int i = 0; i < AMOUNT_INGREDIENT; i++) {
			if (this.ingredients[i] != food.ingredients[i])
				return false;
		}
		return true;
	}

	public boolean IsfoodEmpty() {
		for (int i = 0; i < AMOUNT_INGREDIENT; i++) {
			if (ingredients[i] == true)
				return false;
		}
		return true;
	}

	public boolean getIngredient(int i) {
		return ingredients[i];
	}

	public void setIngredient(int i, boolean have) {
		ingredients[i] = have;
	}
}
