package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy1 extends Enemy{
	private String picture;
	public Enemy1(ArrayList<Tile> path) {
		super(100, 2, 20, path);
		picture = getRandomImagePath();

	}
	

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/1/desert1.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/1/ice1.png";
	    }else {
		path = "assets/volcano/enemies/1/volcano1.png";
	    }
	    return path;
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 1";
		
	}

}
