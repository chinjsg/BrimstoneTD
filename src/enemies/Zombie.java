package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Zombie extends Enemy{
	private   double x;
	private   double y;
	private Image picture;
	public Zombie(ArrayList<Tile> path) {
		super(100, 2, 20, path);
		picture = new Image("DesertCommon.png");
	}
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "ZOMBIE";
		
	}

}
