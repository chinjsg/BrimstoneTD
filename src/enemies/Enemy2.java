package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy2 extends Enemy{
	private String picture;
	public Enemy2(ArrayList<Tile> path) {
		super(105, 2, 25, path);
		picture = "assets/desert/enemies/2/desert2.png";
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 2";
		
	}
}
