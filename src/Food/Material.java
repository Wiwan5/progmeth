package Food;

import java.util.ArrayList;
import Utility.Pair;

public abstract class Material  {
	private boolean  Cancarry;
	private boolean  Settle;
	private String name;
	private Pair<Double,Double> position;
	
	
	
	public Material(String name,boolean cc,boolean st,double x, double y) {
		// TODO Auto-generated constructor stub
		this.name =name;
		Cancarry = cc;
		Settle = st;
		position=Pair.make_pair(x,y);
	}
	

	
	
	
	
}
