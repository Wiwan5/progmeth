package Food;

import java.util.ArrayList;

public abstract class Material implements Moveable {
	private boolean  Cancarry;
	private boolean  Settle;
	private boolean  isDirty;
	private ArrayList<Ingredient>	ing;
	
	public Material() {
		// TODO Auto-generated constructor stub
		isDirty = false;
		Cancarry = false;
		Settle = false;
	}
	
	
	@Override
	public void wash() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void puff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void carry() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
