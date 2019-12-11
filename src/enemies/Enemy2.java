package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy2 extends Enemy{
	private String picture;
	public Enemy2(ArrayList<Tile> path) {
		super(105, 2, 25, path);
		picture = "assets/desert/enemies/2/desert2.png";
	}

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/2/desert2.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/2/ice2.png";
	    }else {
		path = "assets/volcano/enemies/2/volcano2.png";
	    }
	    return path;
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 2";
		
	}
}
