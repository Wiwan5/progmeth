package Utility;

import java.util.HashMap;
import java.util.List;

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
			player1.put(-i,new Image("file:res/img/"+"-p"+i+".png"));
		}
	}
	
	//material
	public static Image[] counter;  //1->normal 2->veg 3->meat 4->br
	public static Image[] pan;
	public static Image plate;
	public static Image[] knift; // 
	
	//ingredient
	public static Image bread;
	public static Image veg = new Image("file:res/img/veg7.png");
	public static Image meat = new Image("file:res/img/meat8.png");
	
	
	

	//mix
	public Image brVeg;
	public Image brMeat=new Image("file:res/img/brm.png");
	public Image brVM =new Image("file:res/img/brmv.png"); 
	
	
	//public static AudioClip click_sound = new AudioClip(ClassLoader.getSystemResource("click.wav").toString());	
	//public static AudioClip game_music = new AudioClip();
	
	
}
