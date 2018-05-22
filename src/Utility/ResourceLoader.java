package Utility;

import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResourceLoader {
	// background
	public static final Image bg0 = new Image("file:res/img/bg0.png"); // menu
	public static final Image bg1 = new Image("file:res/img/bg1.png"); // game

	// Icon
	public static final Image icon = new Image("file:res/img/icon.png");
	public static final Image logo = new Image("file:res/img/logo.png");

	// player
	public static HashMap<Integer, Image> player1 = new HashMap<>(); // pair 1->up 2->down [1]->left [2]->front
																		// [3]->right [4]->back
	static {
		for (int i = 1; i < 5; i++) {
			player1.put(i, new Image("file:res/img/" + "p" + i + ".png"));

		}
	}

	public static Image[] counter = new Image[10]; // veg meat br plate

	// ingredient
	public static Image bread = new Image("file:res/img/bread.png");
	public static Image[] veg = new Image[8];
	public static Image[] meat = new Image[11];

	// mix
	public static final Image brVeg = new Image("file:res/img/brveg.png");
	public static final Image brMeat = new Image("file:res/img/brm.png");
	public static final Image brVM = new Image("file:res/img/brmv.png");
	public static final Image meatV = new Image("file:res/img/mv.png");

	// public static AudioClip game_music = new AudioClip();
	public static AudioClip click_sound = new AudioClip("file:res/sound/click.wav");;
	// public static AudioClip mMusic;
	// public static AudioClip gMusic;
	public static AudioClip gameOver_sound = new AudioClip("file:res/sound/gameOver.wav");

	public static AudioClip rip_sound = new AudioClip("file:res/sound/rip.wav");
	public static AudioClip chop_sound = new AudioClip("file:res/sound/chop.mp3");

	static {
		// load ingradient
		for (int i = 0; i < 11; i++) {
			meat[i] = new Image("file:res/img/meat" + i + ".png");
			if (i < 8) {
				veg[i] = new Image("file:res/img/veg" + i + ".png");
			}
			// 0-7 chop 8-9 rip
		}

		// load counter
		for (int i = 0; i < 10; i++) {
			counter[i] = new Image("file:res/img/" + "counter" + i + ".png");
		}
	}
}
