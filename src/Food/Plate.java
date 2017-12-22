package Food;

import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Plate extends Material implements Moveable{
	
	private Set<Ingredient>	ing;
	private boolean hasth ;
	private String name;
	
	public Plate(){
		super("plate",true,true,	);	// !indicate position of plate x,y
		
	}
/*
	public void wash() {
		
	}
*/
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getx() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getY() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean iscollide() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	//Getter && Setter
	public Set<Ingredient> getIng() {
		return ing;
	}

	public void setIng(Set<Ingredient> ing) {
		this.ing = ing;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isHasth() {
		return hasth;
	}

	public void setHasth(boolean hasth) {
		this.hasth = hasth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
