package Food;

import java.util.ArrayList;

public abstract class Material implements Moveable {
	private boolean  Cancarry;
	private boolean  Settle;
	private boolean  isDirty;
	private String name;
	
	
	public Material(String name) {
		// TODO Auto-generated constructor stub
		isDirty = false;
		Cancarry = false;
		Settle = false;
		this.name = name;
	}
	
	
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void carry() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw() {
		
	}
	
	
	
	
}
