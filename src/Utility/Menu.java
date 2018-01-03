package Utility;

import java.util.HashMap;
import javafx.scene.image.Image;

public class Menu {
	public static HashMap<String,Image> m ; 
	Menu(){
		m = new HashMap<>(); 
		m.put("bread",ResoureLoader.bread);
		m.put("veg",ResoureLoader.veg);
		m.put("meat", ResoureLoader.meat);
	}
	public Image get(String a) {
		return m.get(a);
	}
}
