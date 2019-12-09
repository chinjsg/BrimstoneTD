package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy3 extends Enemy {
	private Image picture;
	public Enemy3(ArrayList<Tile> path) {
		super(110, 2, 27, path);
		picture = new Image("assets/desert/enemies/3/desert3.png");
	}
	@Override
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 3";
		
	}
}
