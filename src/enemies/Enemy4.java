package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy4 extends Enemy{
	private String picture;
	public Enemy4(ArrayList<Tile> path) {
		super(115, 2, 30, path);

		picture = "assets/desert/enemies/4/desert4.png";

	}

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/4/desert4.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/4/ice4.png";
	    }else {
		path = "assets/volcano/enemies/4/volcano4.png";
	    }
	    return path;
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 4";
		
	}
}
