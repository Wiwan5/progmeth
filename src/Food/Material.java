package Food;

import java.util.ArrayList;

public abstract class Material implements Moveable {
	boolean  Cancarry;
	boolean  Settle;
	boolean  isDirty;
	ArrayList<Ingredient>	ing;
	
	public Material() {
		// TODO Auto-generated constructor stub
		isDirty = false;
		Cancarry = false;
		Settle = false;
	}
	
	
	
}
