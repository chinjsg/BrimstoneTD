package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy5 extends Enemy{
	private Image picture;
	public Enemy5(ArrayList<Tile> path) {
		super(120, 2, 32, path);
		picture = new Image(getRandomImagePath());
	}
	

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/5/desert5.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/5/ice5.png";
	    }else {
		path = "assets/volcano/enemies/5/volcano5.png";
	    }
	    return path;
	}
	@Override
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 5";
		
	}
}
