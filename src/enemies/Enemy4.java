package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy4 extends Enemy{
	private String picture;
	public Enemy4(ArrayList<Tile> path) {
		super(115, 2, 30, path);
		picture = "assets/desert/enemies/4/desert4.png";
	}
	@Override
	public String getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 4";
		
	}
}
