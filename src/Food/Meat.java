package Food;

public class Meat extends Ingredient{
	private static boolean Cancop;
	private static boolean Canpuff;
	private static boolean raw;
	private static boolean iscop;
	
	public Meat() {
		super(true,true,true,false);
		raw = true;
		iscop = false;
	}
	
	
	//set raw&& is cop

	public static void setRaw(boolean raw) {
		Meat.raw = raw;
	}

	public static void setIscop(boolean iscop) {
		Meat.iscop = iscop;
	}
	
	
	
	
	
	
}
