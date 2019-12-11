package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy6 extends Enemy{
	private String picture;
	public Enemy6(ArrayList<Tile> path) {
		super(130, 2, 35, path);

		picture = "assets/desert/enemies/6/desert6.png";
	}
	

	private String getRandomImagePath() {
	    Random random = new Random();
	    String path = "";
	    int img = random.nextInt(3);
	    if(img == 1) {
		path = "assets/desert/enemies/6/desert6.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/6/ice6.png";
	    }else {
		path = "assets/volcano/enemies/6/volcano6.png";
	    }
	    return path;
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 6";
		
	}
}
