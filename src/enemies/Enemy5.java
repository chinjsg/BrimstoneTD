package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy5 extends Enemy{
	private String picture;
	public Enemy5(ArrayList<Tile> path) {
		super(120, 2, 32, path);
		picture = "assets/desert/enemies/5/desert5.png";
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 5";
		
	}
}
