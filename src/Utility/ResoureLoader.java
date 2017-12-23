package Utility;

import java.util.List;

import javafx.scene.image.Image;

public class ResoureLoader {
	//background
	public static Image bg0 = new Image("file:res/img/bg0.png");
	
	
	//Icon
	public static final Image icon = new Image("file:res/img/icon.png"); 
	public static final Image logo = new Image("file:res/img/logo.png" );
	
	//player
	public static List<Pair<Image,Image>> player1; // pair 1->up 2->down [1]->left [2]->front [3]->right [4]->back
	
	
	//material
	public static Image[] counter;  //1->normal 2->veg 3->meat 4->br
	public static Image[] pan;
	public static Image plate;
	public static Image[] knift; // 
	
	//ingredient
	public static Image bread;
	public static Image[] vag;
	public static Image[] meat;

	//mix
	public Image brVeg;
	public Image brMeat;
	public Image brVM;
	
	
	
	
	
}
