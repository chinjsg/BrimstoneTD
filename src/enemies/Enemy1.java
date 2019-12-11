package enemies;

import java.util.ArrayList;
import java.util.Random;

import game.Tile;
import javafx.scene.image.Image;

/**
 * This is the abstract class that represent all the enemy used in the game 
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */

// Normal enemy 1
public class Enemy1 extends Enemy{
	private String picture;
	/**
	 * This is the constructor 
	 * @param path
	 */
	public Enemy1(ArrayList<Tile> path) {
		super(350, 3, 20, path);
		picture = getRandomImagePath();
	}
	
	/**
	 * This is the return the String of the images which are randomly selected.
	 * @return String
	 */
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
	/**
	 * This will return the image path
	 * @return String
	 */
	@Override
	public String getImage() {
		return picture;
	}
	/**
	 * This will print.
	 * @return String
	 */
	public String toString() {
		return "Enemy 1";
		
	}

}
