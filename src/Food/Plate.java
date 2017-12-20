package Food;

import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Plate extends Material{
	
	private Set<Ingredient>	ing;
	private int x;
	private boolean hasth ;
	private String name;
	
	public Plate(){
		super("plate");
	}
	
	public void wash() {
		
	}
	
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		super.settle();
	}

	@Override
	public void carry() {
		// TODO Auto-generated method stub
		super.carry();
	}

	
	public boolean canPut(Ingredient i) {
		return i.;
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
