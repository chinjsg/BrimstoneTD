package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy3 extends Enemy {
	private String picture;
	public Enemy3(ArrayList<Tile> path) {
		super(110, 2, 27, path);
		picture = getRandomImagePath();
	}

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/3/desert3.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/3/ice3.png";
	    }else {
		path = "assets/volcano/enemies/3/volcano3.png";
	    }
	    return path;
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 3";
		
	}
}
