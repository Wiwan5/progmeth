package Food;

public abstract class Ingredient implements Moveable {
	private boolean cancop;
	private boolean canpuff;
	private boolean raw;
	private boolean iscop;
	
	public Ingredient(boolean cop,boolean puff,boolean raw,boolean iscop) {
		// TODO Auto-generated constructor stub
		cancop = cop;
		canpuff =puff;
		this.raw = raw;
		this.iscop = iscop;
	}
	
	
	
	
	
	
	
	
	@Override
	public void carry() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		
	}
	
	

}
