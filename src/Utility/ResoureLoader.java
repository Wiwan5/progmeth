package Utility;

import java.util.HashMap;


import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResoureLoader {
	//background
	public static Image bg0 = new Image("file:res/img/bg0.png");
	
	
	//Icon
	public static final Image icon = new Image("file:res/img/icon.png"); 
	public static final Image logo = new Image("file:res/img/logo.png" );
	
	//player
	public static HashMap<Integer,Image> player1 = new HashMap<>(); // pair 1->up 2->down [1]->left [2]->front [3]->right [4]->back
	static {
		for(int i=1;i<5;i++) {
			player1.put(i,new Image("file:res/img/"+"p"+i+".png"));
			
		}
	}
	
	//material
	/*
	public static HashMap<String, Image> counter;  // veg meat br plate 
	static {
		counter.put("counter1",new Image("file:res/img/"+"counter"+0+".png"));
		counter.put("counter2",new Image("file:res/img/"+"counter"+1+".png"));
		counter.put("counter3",new Image("file:res/img/"+"counter"+2+".png"));
		counter.put("counter4",new Image("file:res/img/"+"counter"+3+".png"));
		
		counter.put("chest",new Image("file:res/img/"+"counter"+5+".png"));
		
		
		counter.put("meat",new Image("file:res/img/"+"counter"+8+".png"));
		counter.put("veg",new Image("file:res/img/"+"counter"+9+".png"));
		counter.put("bread",new Image("file:res/img/"+"counter"+10+".png"));
	}
	*/
	public static Image[] pan;
	public static Image plate;
	public static Image[] knift; // 
	
	//ingredient
	public static Image bread = new Image("file:res/img/bread.png");
	public static Image[] veg = new Image[8];
	public static Image[] meat = new Image[10] ;
	public static Image effChop = new Image("file:res/img/chop.gif");
	
	

	//mix
	public Image brVeg;
	public Image brMeat=new Image("file:res/img/brm.png");
	public Image brVM =new Image("file:res/img/brmv.png"); 
	
	
	//public static AudioClip game_music = new AudioClip();
	public static AudioClip click_sound ;
	
	
	static {
		for(int i =0 ;i<10;i++) {
			meat[i] = new Image("file:res/img/meat"+i+".png");
			if(i<8) {
				veg[i] = new Image("file:res/img/veg"+i+".png");
			}
			//0-7 chop 8-9 rip
		}
		
	}
	public static void LoadResource() {
		try {
			click_sound = new AudioClip("file:res/sound/click.wav");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
