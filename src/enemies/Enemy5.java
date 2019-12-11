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
public class Enemy5 extends Enemy{
	private String picture;
	/**
	 * This is the constructor 
	 * @param path
	 */
	public Enemy5(ArrayList<Tile> path) {
		super(400, 4, 80, path);
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
		path = "assets/desert/enemies/5/desert5.png";
	    }else if(img == 2) {
		path ="assets/ice/enemies/5/ice5.png";
	    }else {
		path = "assets/volcano/enemies/5/volcano5.png";
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
		return "Enemy 5";
		
	}
}
